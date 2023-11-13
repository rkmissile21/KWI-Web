package com.kwi;

import com.kwi.base.TestBase;
import com.kwi.pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageValidations extends TestBase {

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    @BeforeClass
    public void navigateToHomePage() {
        homePage.navigateToHomePage();
    }

    @Test(groups = "smoke", enabled = true, priority = 1, description = "Verify the title of the home page")
    public void TC01_ValidateTheTitleOfThePage() {
        homePage.validateTitle();
    }

    @Test(groups = "smoke", enabled = true, priority = 2, description = "Scroll down to the 'All-In-One Omnichannel Solution' section and validate its visibility")
    public void TC02_ValidateAllInOneOmnichannelSolutionText() {
        homePage.scrollDownToAllInOneOmnichannelSolution();
    }

    @Test(groups = "smoke", enabled = true, priority = 3, description = "Print and validate the contact information on the home page")
    public void TC03_ValidateContactInfo() {
        homePage.printContactInfo();
    }

    @Test(groups = "smoke", enabled = true, priority = 4, description = "Click on the 'Platform and Services' link to navigate to the respective page")
    public void TC04_NavigateToPlatformAndServicesPage() {
        homePage.clickOnPlatformAndServices();
    }
}
