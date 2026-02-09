package com.elnie.tests.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int MAX_RETRY = Integer.parseInt(System.getProperty("retries", "1"));

    @Override
    public boolean retry(ITestResult result) {
        if (count < MAX_RETRY) {
            count++;
            System.out.println("Retrying test: " + result.getName() + " attempt " + count);
            return true;
        }
        return false;
    }
}
