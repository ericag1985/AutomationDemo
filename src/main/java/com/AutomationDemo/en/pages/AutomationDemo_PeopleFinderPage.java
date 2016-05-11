package com.AutomationDemo.en.pages;

import com.AutomationDemo.en.BasePage;
import com.AutomationDemo.en.utilities.ScreenshotFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AutomationDemo_PeopleFinderPage extends BasePage{

    //Variables
    @FindBy(css=".btn.btn-primary.btn-xs")
    WebElement button_filters;
    @FindBy(id="filter")
    WebElement container_filters;
    @FindBy(xpath=".//*[@id='filter']/div[1]/div/div[7]/label/input")
    WebElement option_NewYork;
    @FindBy(css=".btn.btn-link.search-clear")
    WebElement button_clearSearch;
    @FindBy(css=".nav li:last-of-type a")
    WebElement link_logout;
    @FindBy(css=".results")
    WebElement container_results;

    public String screenshotFolder = "Automation_Demo_";

    public AutomationDemo_PeopleFinderPage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Search - Isobar People Finder";
    }

    public void clickFilterButton() {
        //Click the filters button
        clickElement(button_filters);
        //If the dropdown is already displayed
        if(container_filters.isDisplayed()) {
            //wait for container
            wait.until(ExpectedConditions.visibilityOf(container_filters));
            //SH the open container
            ScreenshotFactory.captureScreenshot(driver, screenshotFolder, "shownFilter_");
        } else {
            //Else wait for element to be invisible
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("filter")));
            //SH hidden container
            ScreenshotFactory.captureScreenshot(driver, screenshotFolder, "hideFilters_");
        }
    }

    public void clickNewYorkFilter() {
        //Click New York filter
        clickElement(option_NewYork);
        //Wait for results to update
        wait.until(ExpectedConditions.textToBePresentInElement(container_results, "People"));
    }

    public void clickClearSearch() {
        //Click clear search button
        clickElement(button_clearSearch);
        //Wait for results to update
        wait.until(ExpectedConditions.textToBePresentInElement(container_results, "People"));
    }

    public void clickLogoutLink() {
        //Click the logout link
        clickElement(link_logout);
        //Wait until we return to login page
        wait.until(ExpectedConditions.titleContains("Login"));
    }
}
