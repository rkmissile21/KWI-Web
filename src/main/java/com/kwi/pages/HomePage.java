package com.kwi.pages;

import com.kwi.base.TestBase;
import com.kwi.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

/**
 * HomePage class represents the page object for the Home page.
 * It contains methods to interact with elements on the page.
 */

public class HomePage extends TestBase {
    private static Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(css = "a[href='tel:1-800-873-5944']")
    private WebElement contactInfoTell;

    @FindBy(css = "a[href='mailto:sales@kwi.com']")
    private WebElement contactInfoEmailSell;

    @FindBy(css = "a[href='mailto:jobs@kwi.com']")
    private WebElement contactInfoEmailJob;

    @FindBy(xpath = "//p[contains(text(),'ALL-IN-ONE OMNICHANNEL SOLUTION')]")
    private WebElement allInOneOmnichannelSolution;

    @FindBy(xpath = "//a[@href='https://www.kwi.com/platform/'][normalize-space()='Platform & Services']")
    private WebElement platformAndServices;

    @FindBy(xpath = "//li[@id='menu-item-26950']//a[normalize-space()='Loyalty']")
    private WebElement loyalty;


    public void navigateToHomePage() {
        try {
            navigateToURL("https://www.kwi.com");
        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred while navigating to the home page: " + e.getMessage());
            e.printStackTrace();

            ExtentTestManager.log(e.getMessage());

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error navigating to the home page: " + e.getMessage());
        }
    }


    /**
     * Validates that the current URL matches the expected URL.
     * Uses SoftAssert to report multiple assertion failures without stopping the execution.
     */
    public void validateTitle() {
        SoftAssert sa = new SoftAssert();
        String expectedTitle = "RETAIL OMNICHANNEL PLATFORM";

        try {
            String actualTitle = driver.getTitle();
            System.out.println("Page Title: " + actualTitle);
            sa.assertEquals(actualTitle, expectedTitle);
            ExtentTestManager.log("Expected title loaded");
        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred while validating the title: " + e.getMessage());
            e.printStackTrace();

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error validating the title: " + e.getMessage());
        } finally {
            sa.assertAll();
        }
    }

    public void scrollDownToAllInOneOmnichannelSolution() {
        try {
            // Using JavaScriptExecutor to scroll down
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", allInOneOmnichannelSolution);

            // Validate if ALL-IN-ONE OMNICHANNEL SOLUTION text is visible
            if (allInOneOmnichannelSolution.isDisplayed()) {
                ExtentTestManager.log("Expected text is visible: " + allInOneOmnichannelSolution.getText());
            } else {
                ExtentTestManager.log("Expected text is not visible");
            }

            // Print the text to the console
            System.out.println("ALL-IN-ONE OMNICHANNEL SOLUTION: " + allInOneOmnichannelSolution.getText());
        } catch (Exception e) {
            // Handle the exception, log the error or take other appropriate actions
            System.err.println("Exception occurred in scrollDownToAllInOneOmnichannelSolution: " + e.getMessage());
            e.printStackTrace();
            ExtentTestManager.log("Exception occurred: " + e.getMessage());
        }
    }

    public void scrollToBottom() {
        try {
            // Using JavaScriptExecutor to scroll to the bottom
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred while scrolling to the bottom: " + e.getMessage());
            e.printStackTrace();
            ExtentTestManager.log(e.getMessage());

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error scrolling to the bottom: " + e.getMessage());
        }
    }


    public String getPhoneNumber() {
        try {
            return contactInfoTell.getText();
        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred while getting phone number: " + e.getMessage());
            e.printStackTrace();
            ExtentTestManager.log(e.getMessage());


            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error getting phone number: " + e.getMessage());
        }
    }

    public String getEmailOfSell() {
        try {
            return contactInfoEmailSell.getText();
        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred while getting Sell email: " + e.getMessage());
            e.printStackTrace();
            ExtentTestManager.log(e.getMessage());

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error getting Sell email: " + e.getMessage());
        }
    }

    public String getEmailOfJob() {
        try {
            return contactInfoEmailJob.getText();
        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred while getting Job email: " + e.getMessage());
            e.printStackTrace();
            ExtentTestManager.log(e.getMessage());

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error getting Job email: " + e.getMessage());
        }
    }


    public void printContactInfo() {
        SoftAssert sa = new SoftAssert();

        try {
            System.out.println("Contact Info - Phone Number: " + getPhoneNumber());
            ExtentTestManager.log("Contact Info - Phone Number: " + getPhoneNumber());
            sa.assertTrue(contactInfoTell.isDisplayed());

            System.out.println("Contact Info - Sell Email: " + getEmailOfSell());
            ExtentTestManager.log("Contact Info - Sell Email: " + getEmailOfSell());
            sa.assertTrue(contactInfoEmailSell.isDisplayed());

            System.out.println("Contact Info - Job Email: " + getEmailOfJob());
            ExtentTestManager.log("Contact Info - Job Email: " + getEmailOfJob());
            sa.assertTrue(contactInfoEmailJob.isDisplayed());

        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred while printing contact info: " + e.getMessage());
            e.printStackTrace();

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error printing contact info: " + e.getMessage());
        } finally {
            sa.assertAll();
        }
    }


    public void clickOnPlatformAndServices() {
        try {
            platformAndServices.click();
        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred while clicking on Platform & Services: " + e.getMessage());
            e.printStackTrace();

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error clicking on Platform & Services: " + e.getMessage());
        }
    }


    public void mouseOverOnPlatformAndServices() {
        try {
            // Create an instance of the Actions class
            Actions actions = new Actions(driver);

            // Perform a mouse hover over the Platform & Services link
            actions.moveToElement(platformAndServices).perform();

        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred during mouse hover on Platform & Services: " + e.getMessage());
            e.printStackTrace();

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error during mouse hover on Platform & Services: " + e.getMessage());
        }
    }

    public void clickOnLoyalty() {
        try {
            // Click on the Loyalty link
            loyalty.click();

        } catch (Exception e) {
            // Handle the exception, for example, log the error or take a screenshot
            System.err.println("Exception occurred while clicking on Loyalty: " + e.getMessage());
            e.printStackTrace();

            // Optionally, you can throw a custom exception or rethrow the caught exception
            throw new RuntimeException("Error clicking on Loyalty: " + e.getMessage());
        }
    }


}
