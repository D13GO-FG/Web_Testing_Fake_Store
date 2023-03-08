package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.CheckoutOverviewPage;

public class CheckoutOverviewSteps extends BaseSteps{
    CheckoutOverviewPage checkoutOverviewPage;
    public CheckoutOverviewSteps(WebDriver driver) {
        super(driver);
        checkoutOverviewPage = PageFactory.initElements(driver, CheckoutOverviewPage.class);
    }

    public String getPageText(){
        return readText(checkoutOverviewPage.getPageTitle());
    }
}
