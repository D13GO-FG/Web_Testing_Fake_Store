package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObject.InventoryPage;

import java.util.ArrayList;

public class InventorySteps extends BaseSteps{
    InventoryPage inventoryPage;
    public InventorySteps(WebDriver driver) {
        super(driver);
        inventoryPage = PageFactory.initElements(driver, InventoryPage.class);
    }

    public String getPageText(){
        return readText(inventoryPage.getPageTitle());
    }

    public ArrayList<String> productsInInventory(){
        ArrayList<String> products = new ArrayList<String>();
        for (WebElement product: inventoryPage.getListActualProducts()) {
            click(product.findElement(By.tagName("button")));
            products.add(readText(product.findElement(By.className("inventory_item_name"))));
        }
        return products;
    }

    public void clickCartLink(){
        click(inventoryPage.getCartLink());
    }
}
