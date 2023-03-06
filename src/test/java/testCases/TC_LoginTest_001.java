package testCases;

import org.testng.annotations.Test;
import steps.InventorySteps;
import steps.LoginSteps;

import static org.testng.Assert.assertEquals;

public class TC_LoginTest_001 extends BaseTest{

    @Test()
    public void verifySuccessfulLogin(){
        LoginSteps loginSteps = new LoginSteps(driver);
        InventorySteps productsSteps = new InventorySteps(driver);
        loginSteps.typeUsername(username);
        loginSteps.typePassword(password);
        loginSteps.clickLogin();

        assertEquals(productsSteps.getPageText(), "Products", "It's not right page.");
    }
}
