import io.github.bonigarcia.wdm.WebDriverManager;
import model.ConfirmationPopup;
import model.MainView;
import model.OrderView;
import model.SuccessOrderPopup;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class TestOrderTheItemBottomButton {
    private final WebDriver driver;

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

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
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

        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys(userNameInput);
        driver.findElement(By.xpath(".//input[@placeholder='* Фамилия']")).sendKeys(lastNameInput);
        driver.findElement(By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys(addressInput);

        OrderView orderView=new OrderView(driver);
        orderView.clickOnMetroStationSelector();

        orderView.clickOnMetroStation();

        driver.findElement(By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys(phoneNumber);

        orderView.clickOnTheNextButton();

        driver.findElement(By.xpath(".//input[@placeholder='* Когда привезти самокат']")).sendKeys(dateInput);
        orderView.clickOnDatePicker();

        orderView.clickOnTheTerm();
        orderView.selectTheTerm();

        orderView.clickOnCheckboxOption();

        driver.findElement(By.xpath(".//input[@placeholder = 'Комментарий для курьера']")).sendKeys(commentInput);

        orderView.clickOnOrderButton();

        ConfirmationPopup confirmationPopup=new ConfirmationPopup(driver);
        confirmationPopup.waitForLoadPopup();
        confirmationPopup.clickOnConfirmationButton();

        SuccessOrderPopup successPopup = new SuccessOrderPopup(driver);
        successPopup.waitForLoadPopup();
        String textOfMessage = successPopup.getStatusOfTheOrder();

        assertThat(textOfMessage, containsString("Заказ оформлен"));
    }
    @After

    public void quitTheWindow(){
        driver.quit();
    }
}
