package com.telran.demoqa.tests.otherSitesTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OtherSitesTests {
    public EventFiringWebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new EventFiringWebDriver(new ChromeDriver());
//        driver = new EventFiringWebDriver(new FirefoxDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://www.livemaster.ru"); тут 502 ссылки, тест выполняется 15 мин
//        driver.get("https://yandex.ru"); // здесь все ссылки хорошие на момент выполнения теста
        driver.get("https://javarush.ru"); // тут одна битая ссылка из 50
//        driver.get("https://www.tel-ran.de/"); // тест проходит только в Firefox (10 битых из 74), в Chrome падает в середине

    }

    @Test
    public void checkSiteAllLinksTest() {
        selectSiteBrokenLinks();
    }

    public void selectSiteBrokenLinks() {
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("*** Total links on the web page: " + allLinks.size());
        int brokenLinksNum = 0;
        int activeLinksNum = 0;
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getAttribute("href");
            if (verifyLinks(url)) {
                activeLinksNum++;
            } else {
                brokenLinksNum++;
            }
        }
        System.out.println("*** Broken links on the web page: " + brokenLinksNum);
        System.out.println("*** Active links on the web page: " + activeLinksNum);
    }

    private boolean verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURL = (HttpURLConnection) url.openConnection();
            httpURL.setConnectTimeout(5000);
            httpURL.connect();
            if (httpURL.getResponseCode() >= 400) {
                System.out.println("---- " + linkUrl + " - " + httpURL.getResponseMessage() + " is a broken link");
                return false;
            } else {
                System.out.println("++++ " + linkUrl + " - " + httpURL.getResponseMessage());
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!! " + linkUrl + " - " + e.getMessage() + " is a broken link");
            return false;
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
