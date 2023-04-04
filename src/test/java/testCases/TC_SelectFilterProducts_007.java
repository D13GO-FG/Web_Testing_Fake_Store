package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import steps.InventorySteps;

public class TC_SelectFilterProducts_007 extends BaseTest{
    @Test(groups = {"SmokeTest"})
    public void testSelectFilterProduct(){
        InventorySteps inventorySteps = new InventorySteps(getDriver());

        String visibleText1 = "Name (A to Z)";
        Assert.assertEquals(inventorySteps.selectOption(visibleText1), visibleText1);
        String visibleText2 = "Name (Z to A)";
        Assert.assertEquals(inventorySteps.selectOption(visibleText2), visibleText2);
        String visibleText3 = "Price (low to high)";
        Assert.assertEquals(inventorySteps.selectOption(visibleText3), visibleText3);
        String visibleText4 = "Price (high to low)";
        Assert.assertEquals(inventorySteps.selectOption(visibleText4), visibleText4);
    }
}
