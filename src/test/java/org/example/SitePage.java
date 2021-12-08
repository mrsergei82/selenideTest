package org.example;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;
public class SitePage {
    private WebDriver driver;

    private final String site = "https://www.livejournal.com";
    private final String login = "Sergei777777";
    private final String password = "SuperGg1";
    @FindBy(xpath = "//div[@class=\"b-loginform-field__wrap\"]/input")
    private WebElement login_Xp;
    @FindBy(id = "lj_loginwidget_password")
    private WebElement password_id;
    @FindBy(name = "action:login")
    private WebElement actionLog_name;
    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[2]")
    private WebElement button_Enter_xp;


    public SitePage getSite(){
        open(site);
        return this;
    }
    public SitePage toLogin(){
        $(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[2]")).click();
        return this;
    }
    public SitePage logining(){
        Selenide.actions()
                .sendKeys($(By.xpath("//div[@class=\"b-loginform-field__wrap\"]/input")),login)
                .sendKeys($(By.id("lj_loginwidget_password")),password)
                .click($(By.name("action:login"))).build().perform();
        return this;
    }
    public SitePage loginOut() {
        $(By.xpath("//body/div[2]/header/div[1]/nav[2]/ul/li[2]/a/span")).hover();
        $(By.xpath("//body/div[2]/header/div[1]/nav[2]/ul/li[2]/ul/li[14]/a")).click();
        return this;
    }
    public SitePage assert1(){
        $(By.xpath("//body/div[2]/header/div[1]/nav[2]/ul/li[2]/a/span")).shouldHave()
                .text().equals("SERGEI777777");
        return this;
    }
    public SitePage assert2(){
        $(By.xpath("//ul[@class='j-nav j-header-nav j-journal-nav']/li[2]/a")).shouldHave()
                .text().equals("ДРУЗЬЯ");
        return this;
    }
    public SitePage assert3(){
        $(By.xpath("//h1/span[1]")).shouldHave().text().equals("ЛЕНТА");
        return this;
    }
    public SitePage assert4(){
        $(By.xpath("//h1/a")).shouldHave().text().equals("Журнал sergei777777");
        return this;
    }
    public SitePage toProfile(){
        $(By.xpath("//body/div[2]/header/div[1]/nav[2]/ul/li[2]/a/span")).click();
        return this;
    }
    public SitePage toFriends(){
        $(By.xpath("//ul[@class='j-nav j-header-nav j-journal-nav']/li[2]/a")).click();
        return this;
    }
    public SitePage toMyProfile(){
        $(By.xpath("//*[@title='Профиль']")).click();
        return this;
    }
}
