package TestCases;

import Pages.LoginPage;
import Utils.CommonMehtods;
import Utils.ConfigsReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginTest extends CommonMehtods {
    @BeforeTest(alwaysRun = true)
    public static void setUp(){
        launchBrowser();
        LoginPage login= new LoginPage();
        sendText(login.userNameBox, ConfigsReader.getPropertyValue("userName"));
        sendText(login.passwordBox, ConfigsReader.getPropertyValue("password"));
        click(login.loginBtn);
    }
@Test
public void run(){
    System.out.println("Hello");
}

    @AfterTest(alwaysRun = true)
    public static void closeBrowser(){
        tearDown();
    }
}
