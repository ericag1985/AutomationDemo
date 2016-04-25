package com.AutomationDemo.en.tests;

import com.AutomationDemo.en.data.Data;
import com.AutomationDemo.en.pages.AutomatinDemo_PeopleFinderPage;
import com.AutomationDemo.en.pages.AutomationDemo_LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by egugliemella on 3/3/16.
 */

public class Demo_Tests extends TestBasePage {

  //Variables
  AutomationDemo_LoginPage automationDemoLoginPage;
  AutomatinDemo_PeopleFinderPage automatinDemoPeopleFinderPage;

  @BeforeClass(alwaysRun = true)
  public void pageFactories() {
    automationDemoLoginPage = PageFactory.initElements(driver, AutomationDemo_LoginPage.class);
    automatinDemoPeopleFinderPage = PageFactory.initElements(driver, AutomatinDemo_PeopleFinderPage.class);

    //Load page
    automationDemoLoginPage.loadPage("https://keystone.isobar.co/peoplefinder/login");
  }

  @Test(groups={"login", "search"}, dataProvider = "userData", dataProviderClass = Data.class)
  public void loginTest(String username, String password) throws InterruptedException {
    automationDemoLoginPage.filloutForm(username, password);
    Assert.assertEquals(driver.getTitle(), automatinDemoPeopleFinderPage.PAGE_TITLE);
  }

  @Test(groups={"search"}, dependsOnMethods = "loginTest", priority = 1)
  public void searchNewYorkEmployeesTest() {
    automatinDemoPeopleFinderPage.clickFilterButton();
    automatinDemoPeopleFinderPage.clickNewYorkFilter();
    automatinDemoPeopleFinderPage.clickClearSearch();
    automatinDemoPeopleFinderPage.clickFilterButton();
  }

  @Test(groups={"login", "search"}, dependsOnMethods = "loginTest", priority = 2)
  public void logoutTest() {
    automatinDemoPeopleFinderPage.clickLogoutLink();
    Assert.assertEquals(driver.getTitle(), automationDemoLoginPage.PAGE_TITLE);
    automationDemoLoginPage.verifyLoggedOut();
  }
}
