package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

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

    public void closeBanner(){
        driver.findElement(By.id("close-fixedban")).click();
    }

    public void clickWithAction(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        element.click();
    }
}


