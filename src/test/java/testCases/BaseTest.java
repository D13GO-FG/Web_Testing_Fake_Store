package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import utilities.ReadConfig;
import utilities.TestListener;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver(){
        return driver.get();
    }

    @BeforeTest(alwaysRun = true, description = "Running setup driver")
    @Parameters("browser")
    public void setUp(String browser){
        switch (browser) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("--headless");
                driver.set(new FirefoxDriver(optionsFirefox));
                //driver.set(new FirefoxDriver());
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions optionsEdge = new EdgeOptions();
                optionsEdge.addArguments("--headless");
                driver.set(new EdgeDriver(optionsEdge));
//              driver.set(new EdgeDriver());
            }
            default -> System.out.println("Browser " + browser + " is not support");
        }
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get().get(baseURL);
    }

    @AfterTest(alwaysRun = true)
    public void teardown(){
            driver.get().quit();
            driver.remove();
    }

//    @AfterMethod
//    public void screenShot(ITestResult result) {
//
//        // ITestResult.FAILURE is equals to result.getStatus then it enter into
//        // if condition
//
//        if (ITestResult.FAILURE == result.getStatus()) {
//            try {
//
//                // To create reference of TakesScreenshot
//                TakesScreenshot screenshot = (TakesScreenshot) driver;
//
//                // Call method to capture screenshot
//                File src = screenshot.getScreenshotAs(OutputType.FILE);
//
//                // Copy files to specific location result.getName() will
//                // return  name of test case so that screenshot name will be same as test case name
//
//                FileUtils.copyFile(src, new File("./screenshots/" + result.getName() + System.currentTimeMillis() + ".png"));
//                System.out.println("Successfully captured a screenshot");
//            } catch (Exception e) {
//                System.out.println("Exception while taking screenshot " + e.getMessage());
//            }
//        }
//    }
}
