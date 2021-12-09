package com.telran.demoqa.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PageBase { // класс для универсальных методов
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        // библиотека Page factory
        PageFactory.initElements(driver, this);// в POM = new, инициализация страницы и элементов
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void closeBanner() {
        driver.findElement(By.id("close-fixedban")).click();
    }

    public void clickWithAction(WebElement element) {
        Actions action = new Actions(driver); //явные действия пользователя
        action.moveToElement(element).build().perform();
//        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        element.click();
    }

    public void clickWithJSExecutor(WebElement element, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");  // неявные пользовательские движения
        element.click();
    }

    public void typeWithJSExecutor(WebElement element, int x, int y, String text) {
        if (text != null) {
            clickWithJSExecutor(element, x, y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshot/screen-" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }

    // неявные ожидания
    public void waitUntilElementToBeClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementVisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementInvisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAllElementsVisible(List<WebElement> elements, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


