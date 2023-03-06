package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InventoryPage extends BasePage{
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(how = How.CSS, using = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpack;

    @FindBy(how = How.ID, using = "remove-sauce-labs-backpack")
    private WebElement removeBackpack;

    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeLight;

    @FindBy(how = How.ID, using = "remove-sauce-labs-bike-light")
    private WebElement removeBikeLight;

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getCartLink() {
        return cartLink;
    }

    public WebElement getAddBackpack() {
        return addBackpack;
    }

    public WebElement getRemoveBackpack() {
        return removeBackpack;
    }

    public WebElement getAddBikeLight() {
        return addBikeLight;
    }

    public WebElement getRemoveBikeLight() {
        return removeBikeLight;
    }
}
