package com.telran.demoqa.tests;

import com.telran.demoqa.helpers.MyListener;
import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public EventFiringWebDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp() {
        driver = new EventFiringWebDriver(new ChromeDriver());
//        driver = new EventFiringWebDriver(new FirefoxDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com");

        driver.register(new MyListener());
    }

    @BeforeMethod
    public void startTest(Method m) {
        logger.info("### Start test " + m.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("### PASSED: test method " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: test method " + result.getMethod().getMethodName());
            new PageBase(driver).takeScreenshot();
        }
        System.out.println("===========================");
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }

}
