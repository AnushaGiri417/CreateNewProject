package Pages;

import Utils.CommonMehtods;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMehtods {
    @FindBy(id="txtUsername")
    public WebElement userNameBox;
    @FindBy(id="txtPassword")
    public WebElement passwordBox;
    @FindBy(id="btnLogin")
    public WebElement loginBtn;
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

}
