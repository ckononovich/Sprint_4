package model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

public class OrderView {

    private final WebDriver driver;

    public OrderView (WebDriver driver) {
        this.driver=driver;
    };
    private final By userNameField = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationSelectorCLick = By.xpath(" .//input[@placeholder='* Станция метро']");
    private final By metroStationSelection = By.xpath(" .//div[@class='select-search__select']");
    private final By phoneNumberField = By.xpath(" .//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");
    private final By dateOfOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By termOfRentDropdown = By.xpath(".//div[text()='* Срок аренды']");
    private final By termOfRentDropdownSelection = By.xpath(".//div[@class='Dropdown-menu']");
    private final By colorOfTheItem = By.xpath(".//label[@class='Checkbox_Label__3wxSf']");
    private final By commentToTheOrder = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private final By orderButton = By.xpath(".//div[@class ='Order_Buttons__1xGrp']/button[text()='Заказать']");


    public void setUsersDetailsOnTheFirstPage(String userNameInput, String lastNameInput, String addressInput, String phoneNumberInput){
        driver.findElement(userNameField).sendKeys(userNameInput);
        driver.findElement(lastNameField).sendKeys(lastNameInput);
        driver.findElement(addressField).sendKeys(addressInput);
        driver.findElement(phoneNumberField).sendKeys(phoneNumberInput);
    }

    public void clickOnMetroStationSelector(){
       driver.findElement(metroStationSelectorCLick).click();
   }
    public void clickOnMetroStation(){
        driver.findElement(metroStationSelection).click();
    }

    public void clickOnTheNextButton(){
        driver.findElement(nextButton).click();
    }
    public void setDateOfTheOrder(String datePickerInput){
        driver.findElement(dateOfOrder).sendKeys(datePickerInput);
    }

    public void clickOnDatePicker(){
       driver.findElement(dateOfOrder).sendKeys(Keys.ENTER);
    }

    public void clickOnTheTerm(){
       driver.findElement(termOfRentDropdown).click();
    }

    public void selectTheTerm(){
           driver.findElement(termOfRentDropdownSelection).click();
    }

    public void clickOnCheckboxOption(){
       driver.findElement(colorOfTheItem).click();
    }
    public void setComment(String commentInput){
        driver.findElement(commentToTheOrder).sendKeys(commentInput);
    }

    public void clickOnOrderButton(){
        driver.findElement(orderButton).click();
    }
}
