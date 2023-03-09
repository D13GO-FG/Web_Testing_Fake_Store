package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FailureManager {
    private final WebDriver driver;

    public FailureManager(WebDriver driver) {
        this.driver = driver;
    }

    public void takePngScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("./screenshots/",filename + System.currentTimeMillis() + ".png");

        try {
            Files.move(screenshot.toPath(), destination);
        } catch (IOException e) {
            Log.error("Exception moving screenshot from " + screenshot + " to " + destination + ". Error message: " + e);
        }
    }
}
