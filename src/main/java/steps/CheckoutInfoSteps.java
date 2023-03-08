package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.CheckoutInfoPage;

public class CheckoutInfoSteps extends BaseSteps{
    CheckoutInfoPage checkoutInfoPage;
    public CheckoutInfoSteps(WebDriver driver) {
        super(driver);
        checkoutInfoPage = PageFactory.initElements(driver, CheckoutInfoPage.class);
    }

    public String getPageText(){
        return readText(checkoutInfoPage.getPageTitle());
    }

    public void typeFirstName(String firstName){
        type(checkoutInfoPage.getInputFirstName(), firstName);
    }

    public void typeLastName(String lastName){
        type(checkoutInfoPage.getInputLastName(), lastName);
    }

    public void typeZipCode(String zipCode){
        type(checkoutInfoPage.getInputZipCode(), zipCode);
    }

    public String getErrorMsg(){
        return readText(checkoutInfoPage.getErrorMsg());
    }

    public void clickCloseErrorMsg(){
        click(checkoutInfoPage.getBtnError());
    }

    public void clickContinue(){
        click(checkoutInfoPage.getBtnContinue());
    }
}
