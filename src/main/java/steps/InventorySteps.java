package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.InventoryPage;

public class InventorySteps extends BaseSteps{
    InventoryPage inventoryPage;
    public InventorySteps(WebDriver driver) {
        super(driver);
        inventoryPage = PageFactory.initElements(driver, InventoryPage.class);
    }

    public String getPageText(){
        return readText(inventoryPage.getPageTitle());
    }
}
