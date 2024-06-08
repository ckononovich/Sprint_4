import model.ConfirmationPopup;
import model.MainView;
import model.OrderView;
import model.SuccessOrderPopup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class TestOrderTheItemBottomButton extends BaseSetup {

    public String userNameInput;
    public String lastNameInput;
    public String addressInput;
    public String phoneNumber;
    public String dateInput;
    public String commentInput;

    public TestOrderTheItemBottomButton( String userNameInput, String lastNameInput,
                                      String addressInput, String phoneNumber,String dateInput, String commentInput){
        this.userNameInput=userNameInput;
        this.lastNameInput=lastNameInput;
        this.addressInput=addressInput;
        this.phoneNumber=phoneNumber;
        this.dateInput=dateInput;
        this.commentInput=commentInput;
    }

    @Parameterized.Parameters

    public static Object[][] getFieldsForOrder (){
        return new Object[][]{
                {"Мария","Сидорова","кеанешнг 13", "79221110512","11.07.2011", "Хочу заказ!!!!"},
                {"Евгений","Киров","Улица ИНТЕРЕСНАЯ 12", "79221110536","26.07.2045", "КАК МОЖНО СКОРЕЕ"},
                {"ВАНЕГЕ","Олег","просто улица 2", "79221110578", "12.12.2030", "Я жду"},
        };
    }

    @Test
    public void orderTheItem() {

        MainView mainView = new MainView(driver);
        mainView.clickOnCookieButton();
        mainView.waitForLoadHeader();
        mainView.scrollPage();
        mainView.clickOnOrderButtonAtTheBottom();

        OrderView orderView=new OrderView(driver);
        orderView.setUsersDetailsOnTheFirstPage(userNameInput,lastNameInput,addressInput,phoneNumber);
        orderView.clickOnMetroStationSelector();
        orderView.clickOnMetroStation();
        orderView.clickOnTheNextButton();
        orderView.setDateOfTheOrder(dateInput);
        orderView.clickOnDatePicker();
        orderView.clickOnTheTerm();
        orderView.selectTheTerm();
        orderView.clickOnCheckboxOption();
        orderView.setComment(commentInput);
        orderView.clickOnOrderButton();

        ConfirmationPopup confirmationPopup=new ConfirmationPopup(driver);
        confirmationPopup.waitForLoadPopup();
        confirmationPopup.clickOnConfirmationButton();

        SuccessOrderPopup successPopup = new SuccessOrderPopup(driver);
        successPopup.waitForLoadPopup();
        String textOfMessage = successPopup.getStatusOfTheOrder();

        assertThat(textOfMessage, containsString("Заказ оформлен"));
    }
}
