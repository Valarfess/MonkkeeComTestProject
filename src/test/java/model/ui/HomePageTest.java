package model.ui;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class HomePageTest extends BaseTest {

    @Step("Create new note on site")
    @Test
    public void createNewEntryOnSite() {
        loginPage.openSite("https://my.monkkee.com/#/");
        loginPage.LogIn(BaseTest.NAME, BaseTest.PASSWORD);
        driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
        homePage.createNewNote("Hello world!");
        String newEntryText = "Hello world!";
        Assert.assertEquals(newEntryText,"Hello world!","Success");
    }

    @Step("Delete note on site")
    @Test
    public void deleteEntryOnSite() {
        loginPage.openSite("https://my.monkkee.com/#/");
        loginPage.LogIn(BaseTest.NAME, BaseTest.PASSWORD);
//        driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
        homePage.deleteEntry();
        Assert.assertTrue(homePage.getCheckBox().isEnabled());
    }
}


