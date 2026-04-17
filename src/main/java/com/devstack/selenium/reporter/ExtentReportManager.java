package com.devstack.selenium.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReport() {
        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/extentreport.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Automation Report Results");
        extent.attachReporter(sparkReporter);
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logPass(String message) {
        if(Objects.nonNull(test)) {
            test.log(Status.PASS, message);
        }
    }
    public static void logFail(String message,String errorImg) {
        if(Objects.nonNull(test)) {
            test.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(errorImg).build());
        }
    }

    public static void logSkip(String message,String errorImg) {
        if(Objects.nonNull(test)) {
            test.skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(errorImg).build());
        }
    }

    public static void writeToReport(String message) {
        if(Objects.nonNull(test)) {
            test.log(Status.INFO, message);
        }
    }

    public static void flushReport() {
        if(Objects.nonNull(test)) {
            extent.flush();
        }
    }
}
