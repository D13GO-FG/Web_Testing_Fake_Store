package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutInfoPage extends BasePage{

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "title")
    private WebElement pageTitle;

    @FindBy(how = How.ID, using = "first-name")
    private WebElement inputFirstName;

    @FindBy(how = How.ID, using = "last-name")
    private WebElement inputLastName;

    @FindBy(how = How.ID, using = "postal-code")
    private WebElement inputZipCode;

    @FindBy(how = How.XPATH, using = "//h3[@data-test='error']")
    private WebElement errorMsg;

    @FindBy(how = How.CLASS_NAME, using = "error-button")
    private WebElement btnError;

    @FindBy(how = How.ID, using = "continue")
    private WebElement btnContinue;

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getInputFirstName() {
        return inputFirstName;
    }

    public WebElement getInputLastName() {
        return inputLastName;
    }

    public WebElement getInputZipCode() {
        return inputZipCode;
    }

    public WebElement getErrorMsg() {
        return errorMsg;
    }

    public WebElement getBtnError() {
        return btnError;
    }

    public WebElement getBtnContinue() {
        return btnContinue;
    }
}
