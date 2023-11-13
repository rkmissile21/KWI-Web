package com.kwi;

import com.kwi.base.TestBase;
import com.kwi.pages.HomePage;
import com.kwi.pages.LoyaltyPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoyaltyPageValidations extends TestBase {

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoyaltyPage loyaltyPage = PageFactory.initElements(driver, LoyaltyPage.class);

    @BeforeClass
    public void navigateToHomePage() {
        homePage.navigateToHomePage();
    }

    @Test(groups = "smoke", enabled = true, priority = 5, description = "Validate 'Get More Control' section on Loyalty Page")
    public void TC01_ValidateGetMoreControl() {
        homePage.mouseOverOnPlatformAndServices();
        homePage.clickOnLoyalty();
        loyaltyPage.scrollDownToGetMoreControl();
        loyaltyPage.printTheParagraphOfGetMoreControl();
    }
}
