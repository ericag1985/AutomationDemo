package com.AutomationDemo.en;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by egugliemella on 2/16/16.
 */

public class BasePage {

  //Variables
  public WebDriver driver;
  public WebDriverWait wait;
  public String PAGE_TITLE;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10); //default wait
  }

  //If you need a longer time from default wait
  public WebDriverWait waitFor(WebDriver driver, int seconds){
    WebDriverWait wait = new WebDriverWait(driver, seconds);
    return wait;
  }

  //Back Button action
  public void backButton() { driver.navigate().back(); }

  //Alert Dismiss actions
  public void dismissAlertBox() {
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript( "window.onbeforeunload = function(e){};" );
  }

  //Switches to a new opened window
  public void switchToNewWindow(WebElement element) {
    for(String windowHandle : driver.getWindowHandles()){
      driver.switchTo().window(windowHandle);
    }
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  //Switch back to main window
  public void switchToMainWindow(String element) {
    driver.close();
    driver.switchTo().window(element);
  }

  //Scroll into view to get around fixed headers
  public void scrollIntoView(WebElement element) {
    Point point = element.getLocation();
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.scrollTo(0, "+ (point.getY() - 135) +")");
  }

  //Page load
  public void loadPage(String url) {
    //Opens url passed to function
    driver.get(url);
    //Maximizes window size
    driver.manage().window().maximize();
  }

  //Verify element is on the page and ready to be interacted
  public boolean verifyElementExists(WebElement element) {
    try {
      element.getTagName();
    } catch (NoSuchElementException e) {
      return false;
    }
    return true;
  }

  //Interaction with elements functions
  public void clickElement(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
    element.click();
  }

  public void hoverElement(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
    //Enables actions in browser
    Actions action = new Actions(driver);
    action.moveToElement(element).build().perform();
  }

  public void slideElement(WebElement element) {
    Actions action = new Actions(driver);
    action.dragAndDropBy(element, -100, 0).build().perform();
  }

  public void setElementText(WebElement element, String text) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
    //Clears field if text is already present
    element.clear();
    element.sendKeys(text);
  }

  public void selectDropdownValue(WebElement element, String value) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
    //Finds select box
    Select select = new Select(element);
    select.selectByVisibleText(value);
  }

  //If an element can't be clicked because "something else is in its place" (such as a hidden drop down menu), use a JS click instead of the regular click function.
  public void jsClick(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();", element);
  }
}