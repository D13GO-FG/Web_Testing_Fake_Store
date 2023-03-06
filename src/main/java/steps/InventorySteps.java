package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public String getNameAndClick(WebElement element){
        String nameProduct = readText(element);
        click(element);
        return nameProduct;
    }

    public String addNewBackpack(){
        return getNameAndClick(inventoryPage.getAddBackpack());
    }

    public String addNewBikeLight(){
        return getNameAndClick(inventoryPage.getAddBikeLight());
    }

    public void clickCartLink(){
        click(inventoryPage.getCartLink());
    }
}
