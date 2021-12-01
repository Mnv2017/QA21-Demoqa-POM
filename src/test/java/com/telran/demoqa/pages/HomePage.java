package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = " //body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]")
//    @FindBy(xpath = "//div[@class='category-cards']/div[.='Book Store Application']")
    WebElement bookStoreAppBtn;

    public BookStorePage getBookStore() {
//        clickWithJSExecutor(bookStoreAppBtn,0,500);
        clickWithAction(bookStoreAppBtn);
        return new BookStorePage(driver);
    }

}
