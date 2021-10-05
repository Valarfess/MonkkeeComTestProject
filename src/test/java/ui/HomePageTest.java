package ui;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    @Step("Create new note on site")
    @Test
    public void createNewEntryOnSite() {
        loginPage.openSite("https://my.monkkee.com/#/");
        loginPage.LogIn(NAME, PASSWORD);
        homePage.createNote("Hello world!");
        Assert.assertTrue(homePage.getCheckBoxForAssert().isEnabled(), "Success");
    }

    @Step("Delete note on site")
    @Test
    public void deleteEntryOnSite() {
        loginPage.openSite("https://my.monkkee.com/#/");
        loginPage.LogIn(NAME, PASSWORD);
        homePage.deleteNote();
        Assert.assertTrue(homePage.getCheckBoxForAssert().isDisplayed(), "Delete success");
    }
}


