package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainView {
    private final WebDriver driver;

    public MainView (WebDriver driver) {
        this.driver=driver;
    };

   public By orderButtonAtTheTop = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
   public By orderButtonAtTheBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    public void waitForLoadHeader(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class ='Home_Header__iJKdX']")));
    }

    public By cookieButton = By.id("rcc-confirm-button");

    public void clickOnCookieButton(){

        driver.findElement(cookieButton).click();
    };
    public String itemLink = ".//div[@id = 'accordion__panel-%d']/p";

    public String getItemLink (int itemIndex){
        return driver.findElement(By.xpath(String.format(itemLink, itemIndex))).getText();
   }

    public void scrollPage (){
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_RoadMap__2tal_']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    };

    public String itemLink1 = ".//div[@id = 'accordion__heading-%d']";
    public void clickOnItems(int itemIndex)
    {
        var clickItem = driver.findElement(By.xpath(String.format(itemLink1, itemIndex)));
        System.out.println(clickItem);
        clickItem.click();
    };

    public void clickOnOrderButtonAtTheTop(){
        driver.findElement(orderButtonAtTheTop).click();
    }

    public void clickOnOrderButtonAtTheBottom(){
        driver.findElement(orderButtonAtTheBottom).click();
    }


}
