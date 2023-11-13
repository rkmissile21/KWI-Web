package com.kwi.pages;

import com.kwi.base.TestBase;
import com.kwi.report.ExtentTestManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoyaltyPage extends TestBase {

    @FindBy(xpath = "//h2[normalize-space()='Get more control']")
    private WebElement getMoreControl;

    @FindBy(xpath = "(//div[@class='wpb_wrapper'])[25]")
    private WebElement paragraphOfGetMoreControl;

    @FindBy(xpath = "(//li[@id='menu-item-24798'])[1]")
    private WebElement eBooks;

    public void scrollDownToGetMoreControl() {
        try {
            // Using JavaScriptExecutor to scroll down
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getMoreControl);

            // Validate Get More Control text is visible
            if (!getMoreControl.isDisplayed()) {
                throw new RuntimeException("Get More Control text is not visible");
            }

            // Log success if the expected text is visible
            ExtentTestManager.log("Expected text is visible");

        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred during scrolling to Get More Control: " + e.getMessage());
            e.printStackTrace();

            // Log failure in the test report
            ExtentTestManager.log("Error: " + e.getMessage());

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error scrolling to Get More Control: " + e.getMessage());
        }
    }

    public void printTheParagraphOfGetMoreControl() {
        try {
            String paragraph = paragraphOfGetMoreControl.getText();
            System.out.println("Paragraph Of Get More Control: " + paragraph);
            ExtentTestManager.log("Paragraph Of Get More Control: " + paragraph);
            Assert.assertTrue(paragraphOfGetMoreControl.isDisplayed());
        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred while printing the paragraph of Get More Control: " + e.getMessage());
            e.printStackTrace();

            // Log failure in the test report
            ExtentTestManager.log("Error: " + e.getMessage());

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error printing the paragraph of Get More Control: " + e.getMessage());
        }
    }

    public void clickOnEBooks() {
        try {
            Assert.assertTrue(eBooks.isDisplayed());
            eBooks.click();
        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred while clicking on EBooks: " + e.getMessage());
            e.printStackTrace();

            // Log failure in the test report
            ExtentTestManager.log("Error: " + e.getMessage());

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error clicking on EBooks: " + e.getMessage());
        }
    }

    public void scrollToBottom() {
        try {
            // Using JavaScriptExecutor to scroll to the bottom
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

            // Log success if scrolling is performed without any exception
            ExtentTestManager.log("Scrolled to the bottom of the page");

        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred during scrolling to the bottom: " + e.getMessage());
            e.printStackTrace();

            // Log failure in the test report
            ExtentTestManager.log("Error: " + e.getMessage());

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error scrolling to the bottom: " + e.getMessage());
        }
    }
}
