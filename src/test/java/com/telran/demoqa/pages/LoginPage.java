package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // в POM в метод передается не локатор, а WebElement
    // в @FindBy уже произошел поиск по локатору, возвратили элемент

    @FindBy(id = "userName")// локатор только тут, его можно легко поменять
    WebElement userName;// связываем с этим элементом

    @FindBy(id = "password")
    WebElement pwd;

    @FindBy(id = "login")
    WebElement loginBtn;

    public LoginPage verifyLoginPage() {
        if (loginBtn.isDisplayed()) {
            System.out.println("*** Log in ***");
        } else
            System.out.println("*** Wrong page ***");
        return this;
    }

    public LoginPage clickLogin(){
        System.out.println("***  Click Login ***");
        loginBtn.click();
        return this;
    }

    public ProfilePage login(String userN, String password) {
        type(userName, userN);
        type(pwd, password);
        loginBtn.click();
        return new ProfilePage(driver);
    }

    public LoginPage loginNegative(String userN, String password) {
        type(userName, userN);
        type(pwd, password);
        loginBtn.click();
        return this;
    }

}
