package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.CheckoutInfoSteps;
import steps.CheckoutOverviewSteps;
import utilities.XLUtility;

import java.io.IOException;

import static org.testng.Assert.*;

public class TC_CheckoutFillOutInfoDDT_004 extends BaseTest{
    @Test(dataProvider = "checkoutFillOutData", groups = {"DDT"})
    public void testCheckoutFillOutInfoDDT(String firstName, String lastName, String zipCode, String errorMsg) throws Exception {
        CheckoutInfoSteps checkoutInfoSteps = new CheckoutInfoSteps(getDriver());
        CheckoutOverviewSteps checkoutOverviewSteps = new CheckoutOverviewSteps(getDriver());

        assertEquals(checkoutInfoSteps.getPageText(), "Checkout: Your Information", "It's not right page.");

        checkoutInfoSteps.typeFirstName(firstName);
        checkoutInfoSteps.typeLastName(lastName);
        checkoutInfoSteps.typeZipCode(zipCode);
        checkoutInfoSteps.clickContinue();

        if (errorMsg.equals("Valid")){
            assertEquals(checkoutOverviewSteps.getPageText(), "Checkout: Overview", "It's not right page.");
            getDriver().navigate().back();
        }else {
            assertFalse(false, "You missed a input: " + checkoutInfoSteps.getErrorMsg());
            checkoutInfoSteps.clickCloseErrorMsg();
        }
    }

    @DataProvider(name = "checkoutFillOutData")
    public Object[][] getData() throws IOException {
        //Get data from excel
        String path = System.getProperty("user.dir") + "/src/test/java/testData/CheckoutFillOut.xlsx";
        XLUtility xlUtility = new XLUtility(path);

        int totalRows = xlUtility.getRowCount("Hoja 1");
        int totalCols = xlUtility.getCellCount("Hoja 1", 1);

        Object[][] data = new Object[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) { // index 1 to omit table header
            for (int j = 0; j < totalCols; j++) { // index 0
                data[i - 1][j] = xlUtility.getCellData("Hoja 1", i, j);
            }
        }

        return data;
    }
}
