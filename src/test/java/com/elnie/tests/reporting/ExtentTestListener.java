package com.elnie.tests.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        String name = result.getTestClass().getName() + "." + result.getMethod().getMethodName();
        test.set(extent.createTest(name));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
