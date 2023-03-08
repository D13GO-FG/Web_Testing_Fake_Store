package steps;

import org.openqa.selenium.By;
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
            products.add(product.findElement(By.className("inventory_item_name")).getText());
        }
        return products;
    }

    public Double totalPrice(){
        double total = 0;
        for (WebElement product: cartPage.getProductAdded()) {
            total += Double.parseDouble(product.findElement(By.className("inventory_item_price")).getText().replace("$", ""));
        }
        return total;
    }

    public void clickCheckout(){
        click(cartPage.getBtnCheckout());
    }

}
