package com.AutomationDemo.en.pages;

import com.AutomationDemo.en.BasePage;
import com.AutomationDemo.en.utilities.ScreenshotFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by riddelz on 4/24/2016.
 */
public class AutomatinDemo_PeopleFinderPage extends BasePage{

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

    //Screenshot folder
    public String screenshotFolder = "PF_Search_Page_";

    public AutomatinDemo_PeopleFinderPage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Search - Isobar People Finder";
    }

    public void clickFilterButton() {
        clickElement(button_filters);

        if(container_filters.isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOf(container_filters));
            ScreenshotFactory.captureScreenshot(driver, screenshotFolder, "shownFilter_");
        } else {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("filter")));
            ScreenshotFactory.captureScreenshot(driver, screenshotFolder, "hideFilters_");
        }
    }

    public void clickNewYorkFilter() {
        clickElement(option_NewYork);
        wait.until(ExpectedConditions.textToBePresentInElement(container_results, "People"));
        ScreenshotFactory.captureScreenshot(driver, screenshotFolder, "newYorkEmployees_");
    }

    public void clickClearSearch() {
        clickElement(button_clearSearch);
        wait.until(ExpectedConditions.textToBePresentInElement(container_results, "People"));
        ScreenshotFactory.captureScreenshot(driver, screenshotFolder, "clearedSearch_");
    }

    public void clickLogoutLink() {
        clickElement(link_logout);
        wait.until(ExpectedConditions.titleContains("Login"));
    }
}
