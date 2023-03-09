package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.InventorySteps;
import steps.LoginSteps;
import utilities.RetryAnalyzer;
import utilities.XLUtility;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class TC_LoginDDT_002 extends BaseTest{

    @Test(dataProvider = "LoginData", groups = {"TC_1_DDT"}, retryAnalyzer = RetryAnalyzer.class)
    public void testCredentialsLogin(String user, String pwd, String exp){
        LoginSteps loginSteps = new LoginSteps(getDriver());
        InventorySteps productsSteps = new InventorySteps(getDriver());
        loginSteps.typeUsername(user);
        loginSteps.typePassword(pwd);
        loginSteps.clickLogin();

        if (exp.equals("Valid")){
            assertEquals(productsSteps.getPageText(), "Products", "It's not right page.");
            getDriver().navigate().back();
        }else {
            assertEquals(loginSteps.getTextError(), "Epic sadface: Sorry, this user has been locked out.", "This is not right error message");
        }
    }

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws IOException {
        //Get data from excel
        String path = System.getProperty("user.dir") + "/src/test/java/testData/loginData.xlsx";
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
