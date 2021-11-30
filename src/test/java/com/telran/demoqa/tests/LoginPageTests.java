package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).tapBookStoreAppBtn().verifyLoginPage().clickLogin();
    }

    @Test
    public void loginPositiveTest(){
        new LoginPage(driver).login("mnv2017","Nataly123*").verifyUserName("mnv2017").logout();

    }
}
