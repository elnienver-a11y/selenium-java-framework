package com.elnie.tests;

import com.elnie.framework.config.ConfigReader;
import com.elnie.framework.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected ConfigReader config;
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        config = new ConfigReader();
        DriverFactory.initDriver(config.getBoolean("headless"));
        driver = DriverFactory.getDriver();
        driver.get(config.get("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
