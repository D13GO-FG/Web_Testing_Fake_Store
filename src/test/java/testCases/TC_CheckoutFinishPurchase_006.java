package testCases;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import steps.CheckoutCompleteSteps;
import steps.CheckoutOverviewSteps;
import steps.InventorySteps;

import static org.testng.Assert.assertEquals;

public class TC_CheckoutFinishPurchase_006 extends BaseTest{
    @Test(groups = {"SmokeTest"})
    public void testCheckoutFinishPurchase(ITestContext context){
        CheckoutOverviewSteps checkoutOverviewSteps = new CheckoutOverviewSteps(getDriver());
        CheckoutCompleteSteps checkoutCompleteSteps = new CheckoutCompleteSteps(getDriver());
        InventorySteps inventorySteps = new InventorySteps(getDriver());

        assertEquals(checkoutOverviewSteps.getPageText(), "Checkout: Overview", "It's not right page.");

        assertEquals(checkoutOverviewSteps.productsInCheckout(), context.getAttribute("ListProducts"), "Elements added in inventory are not equal to elements in checkout.");
        assertEquals(checkoutOverviewSteps.totalPrice(), context.getAttribute("totalPrice"), "Total amount is not the same.");
        assertEquals(checkoutOverviewSteps.itemTotal(), checkoutOverviewSteps.totalPrice(), "The item total is not the same that is display in overview page.");

        checkoutOverviewSteps.clickFinish();

        assertEquals(checkoutCompleteSteps.getPageText(), "Checkout: Complete!", "It's not right page.");

        assertEquals(checkoutCompleteSteps.getHeader(), "Thank you for your order!", "It's not right page.");

        checkoutCompleteSteps.clickBack();

        assertEquals(inventorySteps.getPageText(), "Products", "It's not right page.");
    }
}
