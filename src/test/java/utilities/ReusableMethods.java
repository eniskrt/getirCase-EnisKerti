package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReusableMethods {

    public static void takeScreenshotFullPage(WebDriver driver) {

        TakesScreenshot tss = (TakesScreenshot) driver;

        LocalDateTime ldt = LocalDateTime.now();
        String dateLabel = "Element" + ldt.getYear() + "-" + ldt.getMonth() + "-" + ldt.getDayOfMonth() + "-" +
                ldt.getHour() + "." + ldt.getMinute() + ".png";
        String  path = "target/screenShots/" + dateLabel;
        File fullScreenScreenshot = new File(path);

        File temporaryScreenshot = tss.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryScreenshot, fullScreenScreenshot);
        } catch (IOException e) {

        }
    }

    public static void webElementScreenshot(WebDriver driver, WebElement webElement) {

        LocalDateTime ldt = LocalDateTime.now();
        String dateLabel = "Element" + ldt.getYear() + "-" + ldt.getMonth() + "-" + ldt.getDayOfMonth() + "-" +
                ldt.getHour() + "." + ldt.getMinute()+ ".png";
        String  path = "target/screenShots/" + dateLabel;
        File fullScreenScreenshot = new File(path);

        File temporaryScreenshot = webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryScreenshot, fullScreenScreenshot);
        } catch (IOException e) {

        }
    }

    public static void wait(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }
}
