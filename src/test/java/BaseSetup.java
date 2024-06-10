import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseSetup {
    WebDriver driver;
 @Before
    public void generalSetUp(){
     WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
     driver.get("https://qa-scooter.praktikum-services.ru/");
 }

 @After

 public void quitTheWindow(){
     driver.quit();
 }
}
