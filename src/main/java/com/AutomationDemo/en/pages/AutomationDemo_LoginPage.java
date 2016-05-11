package com.AutomationDemo.en.pages;

import com.AutomationDemo.en.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

  public AutomationDemo_LoginPage(WebDriver driver) {
    super(driver);
    this.PAGE_TITLE = "Login - Isobar People Finder";
  }

  public void filloutForm(String username, String password) throws InterruptedException {
    //Set username input
    setElementText(input_username, username);
    //Manual wait to see what is happening
    Thread.sleep(1000);
    //Set password input
    setElementText(input_password, password);
    //Manual wait to see what is happening
    Thread.sleep(1000);
    //Click login button
    clickElement(button_login);
    //Wait until page title contains string
    wait.until(ExpectedConditions.titleContains("Search"));
  }

  public void verifyLoggedOut() {
    //Wait for logout text to be present on page
    wait.until(ExpectedConditions.textToBePresentInElement(string_alert, "You have been successfully logged out"));
  }
}
