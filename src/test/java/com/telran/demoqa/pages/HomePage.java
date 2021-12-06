package com.telran.demoqa.pages;

import com.telran.demoqa.pages.bookstorePages.BookStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //    @FindBy(xpath = " //body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]")
    @FindBy(xpath = "//div[@class='category-cards']/div[.='Book Store Application']")
    WebElement bookStoreAppBtn;

    @FindBy(xpath = "//div[@class='category-cards']/div[.='Alerts, Frame & Windows']")
    WebElement alertsFrameAndWindow;

    public BookStorePage getBookStore() {
//        clickWithJSExecutor(bookStoreAppBtn,0,500);
        clickWithAction(bookStoreAppBtn);
        return new BookStorePage(driver);
    }

    public SidePanelPage getAlertsFrameAndWindows() {
        clickWithAction(alertsFrameAndWindow);
        return new SidePanelPage(driver);
    }

    @FindBy(xpath = "//div[@class='category-cards']/div[.='Widgets']")
    WebElement widgets;

    //Widgets
    public SelectMenuPage getWidgets() {
        clickWithAction(widgets);
        return new SelectMenuPage(driver);
    }

    // Forms
    @FindBy(xpath = "//div[@class='category-cards']/div[2]")
    WebElement form;

    public SidePanelPage getForms() {
        clickWithAction(form);
        return new SidePanelPage(driver);
    }
}
