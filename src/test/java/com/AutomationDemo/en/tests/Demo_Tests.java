package com.AutomationDemo.en.tests;

import com.AutomationDemo.en.data.Data;
import com.AutomationDemo.en.pages.AutomationDemo_PeopleFinderPage;
import com.AutomationDemo.en.pages.AutomationDemo_LoginPage;
import com.AutomationDemo.en.utilities.ScreenshotFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo_Tests extends TestBasePage {

  //Variables
  AutomationDemo_LoginPage automationDemoLoginPage;
  AutomationDemo_PeopleFinderPage automatinDemoPeopleFinderPage;
  public String screenshotFolder = "Automation_Demo_";

  @BeforeClass(alwaysRun = true)
  public void pageFactories() {
    automationDemoLoginPage = PageFactory.initElements(driver, AutomationDemo_LoginPage.class);
    automatinDemoPeopleFinderPage = PageFactory.initElements(driver, AutomationDemo_PeopleFinderPage.class);

    //Load page
    automationDemoLoginPage.loadPage("https://keystone.isobar.co/peoplefinder/login");
  }

  @Test(groups={"login", "search"}, dataProvider = "userData", dataProviderClass = Data.class)
  public void loginTest(String username, String password) throws InterruptedException {
    automationDemoLoginPage.filloutForm(username, password);
    Assert.assertEquals(driver.getTitle(), automatinDemoPeopleFinderPage.PAGE_TITLE);
    ScreenshotFactory.captureScreenshot(driver, screenshotFolder, "successfulLogin_");
  }

  @Test(groups={"search"}, dependsOnMethods = "loginTest", priority = 1)
  public void searchNewYorkEmployeesTest() {
    automatinDemoPeopleFinderPage.clickFilterButton();
    //Screenshot lives in method to account for IF statement
    automatinDemoPeopleFinderPage.clickNewYorkFilter();
    ScreenshotFactory.captureScreenshot(driver, screenshotFolder, "newYorkEmployees_");
    automatinDemoPeopleFinderPage.clickClearSearch();
    ScreenshotFactory.captureScreenshot(driver, screenshotFolder, "clearedSearch_");
    automatinDemoPeopleFinderPage.clickFilterButton();
    //Screenshot lives in method to account for IF statement
  }

  @Test(groups={"login", "search"}, dependsOnMethods = "loginTest", priority = 2)
  public void logoutTest() {
    automatinDemoPeopleFinderPage.clickLogoutLink();
    Assert.assertEquals(driver.getTitle(), automationDemoLoginPage.PAGE_TITLE);
    automationDemoLoginPage.verifyLoggedOut();
    ScreenshotFactory.captureScreenshot(driver, screenshotFolder, "successfulLogout_");
  }
}
