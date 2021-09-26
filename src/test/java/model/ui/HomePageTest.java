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
        loginPage.LogIn(NAME, PASSWORD);
        String note = "Hello world!";
        homePage.createNewNote(note);
        Assert.assertEquals(note,note,"Success");
    }

    @Step("Delete note on site")
    @Test
    public void deleteEntryOnSite() {
        loginPage.openSite("https://my.monkkee.com/#/");
        loginPage.LogIn(NAME, PASSWORD);
        homePage.deleteEntry();
        Assert.assertTrue(homePage.getCheckBox().isEnabled(), "Delete success");
    }
}


