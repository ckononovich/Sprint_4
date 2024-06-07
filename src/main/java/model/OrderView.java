package model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

public class OrderView {

    private final WebDriver driver;

    public OrderView (WebDriver driver) {
        this.driver=driver;
    };

    private final By metroStationSelectorCLick = By.xpath(" .//input[@placeholder='* Станция метро']");
    private final By metroStationSelection = By.xpath(" .//div[@class='select-search__select']");
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");
    private final By dateOfOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By termOfRentDropdown = By.xpath(".//div[text()='* Срок аренды']");
    private final By termOfRentDropdownSelection = By.xpath(".//div[@class='Dropdown-menu']");
    private final By colorOfTheItem = By.xpath(".//label[@class='Checkbox_Label__3wxSf']");
    private final By orderButton = By.xpath(".//div[@class ='Order_Buttons__1xGrp']/button[text()='Заказать']");

   public void clickOnMetroStationSelector(){
       driver.findElement(metroStationSelectorCLick).click();
   }
    public void clickOnMetroStation(){
        driver.findElement(metroStationSelection).click();
    }

    public void clickOnTheNextButton(){
        driver.findElement(nextButton).click();
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

    public void clickOnOrderButton(){
        driver.findElement(orderButton).click();
    }


}
