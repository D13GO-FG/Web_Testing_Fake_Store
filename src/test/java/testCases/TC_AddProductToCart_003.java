package testCases;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import steps.CartSteps;
import steps.InventorySteps;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TC_AddProductToCart_003 extends BaseTest{

    @Test(alwaysRun = true, groups = {"SmokeTest", "TC_2_DDT"})
    public void testAddNewProducts(ITestContext context){
        InventorySteps inventorySteps = new InventorySteps(getDriver());
        CartSteps cartSteps = new CartSteps(getDriver());
        // Add products to cart
        ArrayList<String> expectedProductsInventory = inventorySteps.productsInInventory();
        // Click in cart link
        inventorySteps.clickCartLink();
        // Verify if is the right page
        assertEquals(cartSteps.getPageText(), "Your Cart", "It's not right page.");
        // Read title of products in cart
        ArrayList<String> actualProductsCart = cartSteps.productsInCart();
        //Verify if are the same
        assertEquals(actualProductsCart, expectedProductsInventory, "Elements added in inventory are not equal to elements in cart.");

        context.setAttribute("ListProducts", actualProductsCart);
        context.setAttribute("totalPrice", cartSteps.totalPrice());

        // Click in button checkout
        cartSteps.clickCheckout();


    }
}
