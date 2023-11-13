package com.kwi.report;

import com.relevantcodes.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.Reporter;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    private static ITestContext context;

    public synchronized static ExtentReports getInstance() {
        if (extent == null) {
            File outputDirectory = new File(context.getOutputDirectory());
            File resultDirectory = new File(outputDirectory.getParentFile(), "html");
            extent = new ExtentReports(System.getProperty("user.dir") + "/Report/AutomationReport.html", false);
            Reporter.log("Extent Report Directory" + resultDirectory, true);
            extent.addSystemInfo("Host Name", "KWI").addSystemInfo("Environment",
                    "QA").addSystemInfo("User Name", "Jafor Khan").addSystemInfo("URL", "https://www.kwi.com");
            extent.loadConfig(new File("../KWI-Web/src/test/resources/report-config.xml"));
        }
        return extent;
    }

    public static void setOutputDirectory(ITestContext context) {
        ExtentManager.context = context;
    }
}