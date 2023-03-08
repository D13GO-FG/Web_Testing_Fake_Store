package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CheckoutOverviewPage extends BasePage{
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "title")
    private WebElement pageTitle;

    @FindBy(how = How.CLASS_NAME, using = "cart_item")
    private List<WebElement> productAdded;

    @FindBy(how = How.ID, using = "finish")
    private WebElement btnFinish;

    @FindBy(how = How.CLASS_NAME, using = "summary_subtotal_label")
    private WebElement itemTotal;

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public List<WebElement> getProductAdded() {
        return productAdded;
    }

    public WebElement getBtnFinish() {
        return btnFinish;
    }

    public WebElement getItemTotal() {
        return itemTotal;
    }
}
