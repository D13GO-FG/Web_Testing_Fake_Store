package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import steps.CartSteps;
import steps.InventorySteps;

import java.util.ArrayList;

public class TC_AddProductToCart_003 extends BaseTest{

    @Test(groups = "SmokeTest")
    public void testAddNewProducts(){
        InventorySteps inventorySteps = new InventorySteps(getDriver());
        CartSteps cartSteps = new CartSteps(getDriver());

        ArrayList<String> listProductAdded = new ArrayList<String>();
        System.out.println(inventorySteps.getPageText());
        listProductAdded.add(inventorySteps.addNewBackpack());
        listProductAdded.add(inventorySteps.addNewBikeLight());

        inventorySteps.clickCartLink();

        Assert.assertEquals(listProductAdded, cartSteps.productsInCart(), "Elements added in inventory are not equal to elements in cart.");
    }
}
