package com.AutomationDemo.en.pages;

import com.AutomationDemo.en.BasePage;
import com.AutomationDemo.en.utilities.ScreenshotFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by egugliemella on 3/3/16.
 */
public class AutomationDemo_LoginPage extends BasePage {

  //Variables
  @FindBy(name="username")
  WebElement input_username;
  @FindBy(css="input[name=\"password\"]")
  WebElement input_password;
  @FindBy(xpath="html/body/div/form/button")
  WebElement button_login;
  @FindBy(css=".alert.alert-warning>p")
  WebElement string_alert;

  //Screenshot folder
  public String screenshotFolder = "PF_Login_Page_";

  public AutomationDemo_LoginPage(WebDriver driver) {
    super(driver);
    this.PAGE_TITLE = "Login - Isobar People Finder";
  }

  public void filloutForm(String username, String password) throws InterruptedException {
    setElementText(input_username, username);
    Thread.sleep(1000);
    setElementText(input_password, password);
    Thread.sleep(1000);
    clickElement(button_login);
    wait.until(ExpectedConditions.titleContains("Search"));
    ScreenshotFactory.captureScreenshot(driver, screenshotFolder, "successfulLogin_");
  }

  public void verifyLoggedOut() {
    wait.until(ExpectedConditions.textToBePresentInElement(string_alert, "You have been successfully logged out"));
    ScreenshotFactory.captureScreenshot(driver, screenshotFolder, "successfulLogout_");
  }
}
