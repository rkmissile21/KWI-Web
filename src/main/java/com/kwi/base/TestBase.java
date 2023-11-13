package com.kwi.base;

import com.kwi.report.ExtentManager;
import com.kwi.report.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * TestBase class provides common setup and teardown methods for test automation.
 */
public class TestBase {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static String sauceUserName = "";
    public static String sauceKey = "";
    public static String browserStackUserName = "";
    public static String browserStackKey = "";
    public static String SAUCE_URL = "http://" + sauceUserName + ":" + sauceKey + "@ondemand.saucelabs.com:80/wd/hub";
    public static String BROWSERSTACK_URL = "https://" + browserStackUserName + ":" + browserStackKey + "@hub-cloud.browserstack.com/wd/hub";
    private static Logger LOGGER = Logger.getLogger(TestBase.class);

    /**
     * This method sets up the WebDriver based on test parameters.
     *
     * @param platform        - Operating system platform.
     * @param platformVersion - Operating system version.
     * @param url             - URL to navigate to.
     * @param browser         - Browser to be used.
     * @param cloud           - Boolean indicating whether to use cloud-based WebDriver.
     * @param browserVersion  - Version of the browser.
     * @param envName         - Environment name (Sauce Labs, BrowserStack, etc.).
     * @return Configured WebDriver instance.
     * @throws MalformedURLException If an exception occurs while creating the WebDriver.
     */
    @Parameters({"platform", "platformVersion", "url", "browser", "cloud", "browserVersion", "envName"})
    @BeforeMethod
    public static WebDriver setupDriver(String platform, String platformVersion, String url, String browser,
                                        boolean cloud, String browserVersion, String envName) throws MalformedURLException {
        if (cloud) {
            driver = getCloudDriver(browser, browserVersion, platform, platformVersion, envName);
        } else {
            driver = getLocalDriver(browser);
        }
        driver.get(url);
        return driver;
    }

    /**
     * Creates a local WebDriver instance based on the provided browser.
     *
     * @param browser The browser to be used.
     * @return Local WebDriver instance.
     */
    public static WebDriver getLocalDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = WebDriverManager.edgedriver().create();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = WebDriverManager.firefoxdriver().create();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = WebDriverManager.safaridriver().create();
        }
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * Creates a cloud-based WebDriver instance based on the provided parameters.
     *
     * @param browser         The browser to be used.
     * @param browserVersion  The version of the browser.
     * @param platform        The operating system platform.
     * @param platformVersion The operating system version.
     * @param envName         The environment name (Sauce Labs, BrowserStack, etc.).
     * @return Cloud-based WebDriver instance.
     * @throws MalformedURLException If an exception occurs while creating the WebDriver.
     */
    public static WebDriver getCloudDriver(String browser, String browserVersion, String platform, String platformVersion,
                                           String envName) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("resolution", "1920x1080");
        desiredCapabilities.setCapability("browser", browser);
        desiredCapabilities.setCapability("browser_version", browserVersion);
        desiredCapabilities.setCapability("os", platform);
        desiredCapabilities.setCapability("os_version", platformVersion);
        desiredCapabilities.setCapability("name", "Sample Test");

        if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL(SAUCE_URL), desiredCapabilities);
            LOGGER.info("Tests run on Sauce Lab");
        } else if (envName.equalsIgnoreCase("browserstack")) {
            driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL), desiredCapabilities);
            LOGGER.info("Tests run on Browser Stack");
        }
        return driver;
    }

    /**
     * Navigates the browser to the provided URL.
     *
     * @param url The URL to navigate to.
     */
    public static void navigateToURL(String url) {
        driver.get(url);
        LOGGER.info("Navigated to the URL: " + url);
    }

    /**
     * Pauses the execution for the specified number of seconds.
     *
     * @param seconds The number of seconds to sleep.
     */
    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the WebDriver instance.
     */
    public static void closeDriver() {
        driver.quit();
        LOGGER.info("Closed the instance of the driver");
    }

    /**
     * Navigates back from the current page to the previous page.
     */
    public static void navigateBack() {
        driver.navigate().back();
    }

    /**
     * Clicks on the element identified by the provided XPath.
     *
     * @param element The XPath of the element to click.
     */
    public static void clickOnElement(String element) {
        driver.findElement(By.xpath(element)).click();
    }

    /**
     * Captures a screenshot and saves it with the specified name and timestamp.
     *
     * @param driver         The WebDriver instance.
     * @param screenshotName The name to be used for the screenshot file.
     */
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        DateFormat df = new SimpleDateFormat("HH_mm_ss");
        Date date = new Date();
        df.format(date);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + " " + df.format(date) + ".jpg"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

    // Reporting starts

    /**
     * Sets up the ExtentReports instance before the suite runs.
     *
     * @param context The TestNG context.
     */
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    /**
     * Starts a new ExtentTest for each test method.
     *
     * @param method The test method.
     */
    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    /**
     * Retrieves the stack trace as a string.
     *
     * @param t The throwable object.
     * @return The stack trace as a string.
     */
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    /**
     * Handles the completion of each test method and logs the test status in the Extent report.
     *
     * @param result The test result.
     */
    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }

        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
    }

    /**
     * Converts milliseconds to a Date object.
     *
     * @param millis The time in milliseconds.
     * @return The corresponding Date object.
     */
    public Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    /**
     * Closes the ExtentReports instance after the suite runs.
     */
    @AfterSuite
    public void generateReport() {
        extent.close();
    }
    // Reporting finish

    /**
     * Cleans up resources and closes the WebDriver instance after each test method.
     */
    @AfterMethod
    public void cleanUp() {
        driver.close();
        driver.quit();
        LOGGER.info("Driver closed");
    }
}
