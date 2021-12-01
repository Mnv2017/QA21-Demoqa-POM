package com.telran.demoqa.pages;

import org.openqa.selenium.By;
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

    public LoginPage clickLogin() {
        System.out.println("***  Click Login ***");
        loginBtn.click();
        return this;
    }

    public ProfilePage login(String userN, String password) {
        type(userName, userN);
        type(pwd, password);
        click(loginBtn);
        return new ProfilePage(driver);
    }

    public LoginPage loginNegative(String userN, String password) {
        type(userName, userN);
        type(pwd, password);
        loginBtn.click();
        return this;
    }

    // перенести в BookStorePage

//    @FindBy(id = "searchBox")
//    WebElement searchInput;
//
//    public LoginPage typeInSearchFieldInput(String text) { // перенести в BookStorePage
//        type(searchInput, text);
//        return this;
//    }

//    @FindBy(xpath = "//span[@class='mr-2']/a")
//    WebElement nameOfBook;
//
//    public String takeNameOfBook() {
////        return  driver.findElement(By.xpath("//span[@class='mr-2']/a")).getText();
//        return nameOfBook.getText();
//    }

//    public String verifyEmptyField() {
//        return driver.findElement(By.cssSelector(".rt-tr-group:nth-child(1) .rt-td:nth-child(2)"))
//                .getText();
//    }
//
//    public LoginPage clickByFirstBook() {
//        click(nameOfBook);
//        return this;
//    }

//    @FindBy(css = ".text-right.fullButton")
//    WebElement addToCollectionButton;
//
//    public LoginPage addToYourCollection() {
//        clickWithJSExecutor(addToCollectionButton,0,500);
//        pause(4000);
//        driver.switchTo().alert().accept(); // нажимаем Ок на alert
//        return this;
//    }
}
