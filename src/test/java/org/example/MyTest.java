package org.example;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MyTest {
    @Test
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @Test
    public void test1(){
        SitePage sitePage = new SitePage();
        sitePage.getSite().toLogin().logining().assert1();
    }
    @Test
    public void test2(){
        SitePage sitePage = new SitePage();
        sitePage.getSite().toLogin().logining().toProfile().assert2();
    }
    @Test
    public void test3(){
        SitePage sitePage = new SitePage();
        sitePage.getSite().toLogin().logining().toProfile().toFriends().assert3();
    }
    @Test
    public void test4(){
        SitePage sitePage = new SitePage();
        sitePage.getSite().toLogin().logining().toProfile().toMyProfile().assert4();
    }

}
