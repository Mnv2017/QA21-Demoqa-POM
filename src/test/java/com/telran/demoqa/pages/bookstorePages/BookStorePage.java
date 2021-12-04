package com.telran.demoqa.pages.bookstorePages;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends PageBase {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "login")
    WebElement loginBtn;

    public LoginPage getLoginPage(){
        click(loginBtn);
        return new LoginPage(driver);
    }

    public BookStorePage verifyLoginPage() {
        if (loginBtn.isDisplayed()) {
            System.out.println("Verify *** Log in ***");
        } else
            System.out.println("*** Wrong page ***");
        return this;
    }

    @FindBy(id = "searchBox")
    WebElement searchInput;

    public BookStorePage typeInSearchFieldInput(String text) { // перенести в BookStorePage
        type(searchInput, text);
        return this;
    }

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement nameOfBook;

    public String takeNameOfBook() {
        return nameOfBook.getText();
    }

    public String verifyEmptyField() {
        return driver.findElement(By.cssSelector(".rt-tr-group:nth-child(1) .rt-td:nth-child(2)"))
                .getText();
    }

    public BookStorePage clickByFirstBook() {
        click(nameOfBook);
        return this;
    }

    @FindBy(css = ".text-right.fullButton")
    WebElement addToCollectionButton;

    public BookStorePage addToYourCollection() {
        clickWithJSExecutor(addToCollectionButton,0,500);
        pause(6000);
        driver.switchTo().alert().accept(); // нажимаем Ок на alert
        return this;
    }
}
