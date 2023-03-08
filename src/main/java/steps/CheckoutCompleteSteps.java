package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.CheckoutCompletePage;

public class CheckoutCompleteSteps extends BaseSteps{
    CheckoutCompletePage checkoutCompletePage;
    public CheckoutCompleteSteps(WebDriver driver) {
        super(driver);
        checkoutCompletePage = PageFactory.initElements(driver, CheckoutCompletePage.class);
    }

    public String getPageText(){
        return readText(checkoutCompletePage.getPageTitle());
    }

    public String getHeader(){
        return readText(checkoutCompletePage.getHeader());
    }

    public void clickBack(){
        click(checkoutCompletePage.getBtnBack());
    }
}
