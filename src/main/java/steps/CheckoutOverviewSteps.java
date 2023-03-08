package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObject.CheckoutOverviewPage;

import java.util.ArrayList;

public class CheckoutOverviewSteps extends BaseSteps{
    CheckoutOverviewPage checkoutOverviewPage;
    public CheckoutOverviewSteps(WebDriver driver) {
        super(driver);
        checkoutOverviewPage = PageFactory.initElements(driver, CheckoutOverviewPage.class);
    }

    public String getPageText(){
        return readText(checkoutOverviewPage.getPageTitle());
    }

    public ArrayList<String> productsInCheckout(){
        ArrayList<String> products = new ArrayList<String>();
        for (WebElement product: checkoutOverviewPage.getProductAdded()) {
            products.add(product.findElement(By.className("inventory_item_name")).getText());
        }
        return products;
    }

    public Double totalPrice(){
        double total = 0;
        for (WebElement product: checkoutOverviewPage.getProductAdded()) {
            total += Double.parseDouble(product.findElement(By.className("inventory_item_price")).getText().replace("$", ""));
        }
        return total;
    }

    public Double itemTotal(){
        return Double.valueOf(checkoutOverviewPage.getItemTotal().getText().replace("Item total: $", ""));
    }

    public void clickFinish(){
        click(checkoutOverviewPage.getBtnFinish());
    }
}
