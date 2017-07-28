package com.kreditech.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CaptureScreenshot {

    private static String filePath;

    public static void takeScreenshot(WebDriver driver) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timeFolder = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String timeStamp = new SimpleDateFormat("dd_HHmmss").format(Calendar.getInstance().getTime());
        filePath = File.separator + "screenshots" + File.separator + timeFolder + File.separator + timeStamp + ".png";

        File screenShotName = new File("." + File.separator + "results" + filePath);
        //save screenshot
        try {
            FileUtils.copyFile(scrFile, screenShotName);
        } catch (IOException e) {
            System.out.println("Exception while taking ScreenShot " + e.getMessage());
        }
    }

    public static void attachScreenshot(WebDriver driver) {
        takeScreenshot(driver);
        //add screenshot to report
        String aLink = "<a href='"+ "." + filePath + "' target='_blank'>";
        String imgScr = "<img src='" + "." + filePath + "' height='108' width='192'/></a>";
        Reporter.log(aLink + imgScr);
    }
}
