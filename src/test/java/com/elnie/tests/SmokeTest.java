package com.elnie.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void openBrowserAndWait() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().length() > 0, "Title should not be empty");
    }
}
