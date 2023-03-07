package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObject.CartPage;

import java.util.ArrayList;

public class CartSteps extends BaseSteps{
    CartPage cartPage;
    public CartSteps(WebDriver driver) {
        super(driver);
        cartPage = PageFactory.initElements(driver, CartPage.class);
    }

    public String getPageText(){
        return readText(cartPage.getPageTitle());
    }

    public ArrayList<String> productsInCart(){
        ArrayList<String> products = new ArrayList<String>();
        for (WebElement product: cartPage.getProductAdded()) {
            products.add(product.getText());
        }
        return products;
    }


}
