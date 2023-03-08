package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "inventory_item_name")
    private List<WebElement> productAdded;

    @FindBy(how = How.CLASS_NAME, using = "title")
    private WebElement pageTitle;

    @FindBy(how = How.ID, using = "checkout")
    private WebElement btnCheckout;

    public List<WebElement> getProductAdded() {
        return productAdded;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getBtnCheckout() {
        return btnCheckout;
    }
}
