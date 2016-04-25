package com.AutomationDemo.en.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by egugliemella on 2/16/16.
 */

public class DriverFactory {

  public enum BrowserType {
    FIREFOX,
    CHROME,
    IE,
    SAFARI
  }

  public static WebDriver getDriver(BrowserType type) {
    WebDriver driver = null;

    switch(type) {
      case FIREFOX:
        driver = new FirefoxDriver();
        break;
      case CHROME:
        System.setProperty("webdriver.chrome.driver", "/Users/egugliemella/projects/SeleniumDrivers/chromedriver");
        driver = new ChromeDriver();
        break;
      default:
        driver = new FirefoxDriver();
        break;
    }

    return driver;
  }
}
