package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.LoginPage;

public class LoginSteps extends BaseSteps{
    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        super(driver);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    public void typeUsername(String username){
        type(loginPage.getInputUserName(), username);
    }

    public void typePassword(String password){
        type(loginPage.getInputPassword(), password);
    }

    public void clickLogin(){
        click(loginPage.getBtnLogin());
    }

    public String getTextError(){
        return readText(loginPage.getMsgError());
    }
}
