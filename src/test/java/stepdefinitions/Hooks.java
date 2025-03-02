package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss");
            String dateLabel = LocalDateTime.now().format(formatter);

            String screenshotDirectory = "target/screenshots/";
            String screenshotName = "Screenshot_" + dateLabel + ".png";
            File screenshotFile = new File(screenshotDirectory + screenshotName);

            File directory = new File(screenshotDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File srcFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile, screenshotFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);

            Driver.quitDriver();
        }
    }
}
