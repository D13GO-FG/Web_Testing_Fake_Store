package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class InventoryPage extends BasePage{
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(how = How.CLASS_NAME, using = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(how = How.CLASS_NAME, using = "inventory_item_description")
    private List<WebElement> listActualProducts;

    @FindBy(how = How.XPATH, using = "//select[@class='product_sort_container']")
    private WebElement selectedFilter;

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getCartLink() {
        return cartLink;
    }

    public List<WebElement> getListActualProducts() {
        return listActualProducts;
    }

    public WebElement getSelectedFilter() {
        return selectedFilter;
    }
}
