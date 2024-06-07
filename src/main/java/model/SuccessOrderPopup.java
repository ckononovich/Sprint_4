package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessOrderPopup {
    private final WebDriver driver;

    public SuccessOrderPopup (WebDriver driver) {
        this.driver=driver;
    };
    public void waitForLoadPopup(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class ='Order_ModalHeader__3FDaJ']")));
    }

    private final By viewStatusText= By.xpath(" .//div[@class ='Order_ModalHeader__3FDaJ']");

    public String getStatusOfTheOrder(){
        return driver.findElement(viewStatusText).getText();

    }

}
