package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutCompletePage extends BasePage{
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "title")
    private WebElement pageTitle;

    @FindBy(how = How.CLASS_NAME, using = "complete-header")
    private WebElement header;

    @FindBy(how = How.ID, using = "back-to-products")
    private WebElement btnBack;

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getHeader() {
        return header;
    }

    public WebElement getBtnBack() {
        return btnBack;
    }
}
