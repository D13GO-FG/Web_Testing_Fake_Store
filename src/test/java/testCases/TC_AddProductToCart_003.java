package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import steps.CartSteps;
import steps.InventorySteps;

public class TC_AddProductToCart_003 extends BaseTest{

    @Test(alwaysRun = true, groups = {"SmokeTest"})
    public void testAddNewProducts(){
        InventorySteps inventorySteps = new InventorySteps(getDriver());
        CartSteps cartSteps = new CartSteps(getDriver());

        Assert.assertEquals(inventorySteps.productsInInventory(), cartSteps.productsInCart(), "Elements added in inventory are not equal to elements in cart.");

        inventorySteps.clickCartLink();

        Assert.assertEquals(cartSteps.getPageText(), "Your Cart", "It's not right page.");
    }
}
