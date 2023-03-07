package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import utilities.ReadConfig;

import java.time.Duration;

public class BaseTest {
    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();

    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeTest(alwaysRun = true, description = "Running setup driver")
    @Parameters("browser")
    public void setUp(String browser){
        switch (browser) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("--headless");
                driver = new FirefoxDriver(optionsFirefox);
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
//                EdgeOptions optionsEdge = new EdgeOptions();
//                optionsEdge.addArguments("--headless");
//                driver = new EdgeDriver(optionsEdge);
                driver = new EdgeDriver();
            }
            default -> System.out.println("Browser " + browser + " is not support");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseURL);
    }

    @AfterTest(alwaysRun = true)
    public void teardown(){
            driver.quit();
    }
}
