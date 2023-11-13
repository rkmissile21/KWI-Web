package com.kwi.pages;

import com.kwi.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * EBooksFormPage class represents the page object for the EBooks form.
 * It contains methods to interact with elements on the form.
 */
public class EBooksFormPage extends TestBase {

    private static Logger LOGGER = Logger.getLogger(EBooksFormPage.class);

    @FindBy(xpath = "//input[@id='input_10_1']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='input_10_3']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='input_10_24']")
    private WebElement companyNameInput;

    @FindBy(xpath = "//input[@id='input_10_4']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='gform_submit_button_10']")
    private WebElement downloadButton;

    /**
     * Sets the first name in the input field.
     */
    public void setFirstNameInput() {
        firstNameInput.sendKeys("Jafor");
    }

    /**
     * Sets the last name in the input field.
     */
    public void setLastNameInput() {
        lastNameInput.sendKeys("Khan");
    }

    /**
     * Sets the company name in the input field.
     */
    public void setCompanyNameInput() {
        companyNameInput.sendKeys("Delta Airlines");
    }

    /**
     * Sets the email in the input field.
     */
    public void setEmailInput() {
        emailInput.sendKeys("khan.asmjafor@gmail.com");
    }

    /**
     * Clicks on the download button.
     */
    public void clickOnDownloadButton() {
        downloadButton.click();
    }
}
