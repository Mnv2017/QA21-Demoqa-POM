package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WindowPage extends PageBase {
    public WindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabBtn;

    public WindowPage clickOnNewTabButton() {
        click(tabBtn);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleText;

    public String getTextFromNewTab() {
        return sampleText.getText();
    }

    @FindBy(id = "windowButton")
    WebElement windowButton;

    public WindowPage clickOnNewWindowButton() {
        click(windowButton);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        return this;
    }

//    @FindBy(id = "messageWindowButton")
//    WebElement messWindowBtn;
//
//    public WindowPage clickOnNewWindowMessageButton() {
//        click(messWindowBtn);
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//        System.out.println("Появилось второе окно");
//        String windowHandler = driver.getWindowHandle();
//        System.out.println("Текущее окно: " + windowHandler);
//        List<String> messWindow2 = new ArrayList<>((driver.getWindowHandles()));
//        System.out.println("Окна2:  " + messWindow2);
//        String win2 = messWindow2.get(1);
//        System.out.println("Окно с текстом: " + win2);
//        driver.switchTo().window(win2);
//        System.out.println("##### Заголовок окна:" + driver.getTitle());
//        driver.manage().window().maximize();
//        return this;
//    }

    @FindBy(css = "body")
    WebElement body;

    public String getTextMessageFromNewWindow() {
        pause(2000);
        WebElement b = driver.findElement(By.cssSelector("body"));
        System.out.println("Элемент body: " + b);
//        return body.getText();
        return "---- Заглушка ----";
    }
}
