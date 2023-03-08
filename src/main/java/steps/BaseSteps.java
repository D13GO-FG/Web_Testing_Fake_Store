package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSteps {
    private WebDriver driver;

    public WebDriver getDriver(){
        return this.driver;
    }

    public static final int SMALL_WAIT = 10;
    public static final int MED_WAIT = 30;
    public static final int MAX_WAIT = 120;
    public static final int MAX_SCROLL = 100;

    public BaseSteps(WebDriver driver){
        this.driver = driver;
    }

    protected WebDriverWait waitOn(WebDriver this_driver, int timeOutSeconds){
        return new WebDriverWait(this_driver, Duration.ofSeconds(timeOutSeconds));
    }

    public WebDriverWait getWait(){
        return waitOn(driver, SMALL_WAIT);
    }

    protected WebElement waitForDisplayedElement(WebElement element, int second) {
        return waitOn(driver, second).until(ExpectedConditions.visibilityOf(element));
    }

    public void type(WebElement element, String text){
        waitForDisplayedElement(element, SMALL_WAIT);
        element.clear();
        element.sendKeys(text);
    }

    public String readText(WebElement element) {
        return waitForDisplayedElement(element, SMALL_WAIT).getText();
    }

    protected void click(WebElement element){
        waitForDisplayedElement(element, SMALL_WAIT).click();
//        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
