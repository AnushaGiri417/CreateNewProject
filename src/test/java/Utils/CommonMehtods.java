package Utils;

import io.github.bonigarcia.wdm.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

@Test
public class CommonMehtods {

public static WebDriver driver;
static String path;


public static void launchBrowser(){
    path = Constants.CONFIG_FILEPATH;
    ConfigsReader.readProperties(path);
     String browser =  ConfigsReader.getPropertyValue("browser");
    switch (browser){
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
    driver.get( ConfigsReader.getPropertyValue( "url" ) );
}



public static void tearDown(){
    if(driver!=null){
        driver.quit();
    }
}

}
