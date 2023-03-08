package testCases;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import steps.CheckoutInfoSteps;
import steps.CheckoutOverviewSteps;

import static org.testng.Assert.assertEquals;

public class TC_CheckoutFillOutInfo_005 extends BaseTest{
    @Test(groups = {"SmokeTest"})
    public void testCheckoutFillOut() {
        Faker faker = new Faker();
        CheckoutInfoSteps checkoutInfoSteps = new CheckoutInfoSteps(getDriver());
        CheckoutOverviewSteps checkoutOverviewSteps = new CheckoutOverviewSteps(getDriver());

        assertEquals(checkoutInfoSteps.getPageText(), "Checkout: Your Information", "It's not right page.");

        checkoutInfoSteps.typeFirstName(faker.name().firstName());
        checkoutInfoSteps.typeLastName(faker.name().lastName());
        checkoutInfoSteps.typeZipCode(faker.address().zipCode());
        checkoutInfoSteps.clickContinue();

        assertEquals(checkoutOverviewSteps.getPageText(), "Checkout: Overview", "It's not right page.");
    }
}
