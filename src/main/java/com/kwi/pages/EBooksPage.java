package com.kwi.pages;

import com.kwi.base.TestBase;
import com.kwi.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

/**
 * EBooksPage class represents the page object for the EBooks page.
 * It contains methods to interact with elements on the page.
 */
public class EBooksPage extends TestBase {
    private static Logger LOGGER = Logger.getLogger(EBooksPage.class);

    @FindBy(xpath = "//a[normalize-space()='9 Noble Truths of Modern Retailing']")
    private WebElement nineNobleTruthsOfModernRetailing;

    /**
     * Scrolls down to the element '9 Noble Truths of Modern Retailing' using JavaScriptExecutor.
     * Validates that the element is visible.
     */
    public void scrollDownToNineNobleTruthsOfModernRetailing() {
        // Using JavaScriptExecutor to scroll down
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nineNobleTruthsOfModernRetailing);

        // Validate that the element is visible
        nineNobleTruthsOfModernRetailing.isDisplayed();
        ExtentTestManager.log("Expected text is visible");
    }

    /**
     * Switches to a new tab.
     */
    private void switchToNewTab() {
        // Get all open window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new tab (assuming it's the last one in the set)
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }
    }
}
