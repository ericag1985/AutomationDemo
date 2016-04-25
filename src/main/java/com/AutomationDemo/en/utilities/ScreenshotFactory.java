package com.AutomationDemo.en.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by egugliemella on 2/16/16.
 */

public class ScreenshotFactory {
  public static void captureScreenshot(WebDriver driver, String folderName, String screenshotName)
  {

    try
    {
      String folderTimeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
      String imageTimeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
      TakesScreenshot ts=(TakesScreenshot)driver;
      File source=ts.getScreenshotAs(OutputType.FILE);

      FileUtils.copyFile(source, new File("./Screenshots/" + folderName + folderTimeStamp + "/" + screenshotName + imageTimeStamp + ".png"));

      System.out.println(screenshotName + imageTimeStamp + " placed in root /screenshots/" + folderName + folderTimeStamp + " folder!");
    }
    catch (Exception e)
    {

      System.out.println("Exception while taking screenshot " + e.getMessage());
    }
  }
}