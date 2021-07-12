package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class CommonMehtods {

    public static WebDriver driver;
    static String path;


    public static void launchBrowser() {
        path = Constants.CONFIG_FILEPATH;
        ConfigsReader.readProperties(path);
        String browser = ConfigsReader.getPropertyValue("browser");
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("choose either firefox or chrome browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICITWAIT, TimeUnit.SECONDS);
        driver.get(ConfigsReader.getPropertyValue("url"));
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
    public static void explicitTimeWait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICITWAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element){
        element.click();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
