package model.ui;

import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTest extends BaseTest {
    @DataProvider(name = "Empty Login Data")
    public Object[][] getEmptyData() {
        return new Object[][]{
                {"", PASSWORD, "Mandatory field"},
                {NAME, "", "Mandatory field"},
        };
    }

    @DataProvider(name = "Wrong Login Data")
    public Object[][] getWrongData() {
        return new Object[][]{
                {NAME, "wrong_password", "Login failed"},
                {"wrong_user", PASSWORD, "Login failed"},
        };
    }
    @Step("Login tests with empty field")
    @Test(groups = "regression", dataProvider = "Empty Login Data")
    public void loginDataShouldBeRequired(String name, String password, String errorMessage){
        loginPage.openSite("https://my.monkkee.com/#/");
        loginPage.LogIn(name,password);
        String error = loginPage.getErrorMessage();
        assertEquals(error,errorMessage,"Fail");
    }
    @Step("Login tests with wrong data")
    @Test(groups = "negative", dataProvider = "Wrong Login Data")
    public void correctLoginDataShouldBeRequired(String name, String password, String errorMessage1){
        loginPage.openSite("https://my.monkkee.com/#/");
        loginPage.LogIn(name,password);
        String error = loginPage.getErrorMessage1();
        assertEquals(error,errorMessage1,"Fail");
    }
    @Step("Success login")
    @Test(groups = "smoke", description = "Successful login")
    public void Login(){
        loginPage.openSite("https://my.monkkee.com/#/");
        loginPage.LogIn(NAME, PASSWORD);
        assertTrue(loginPage.getLoginButton().isEnabled(), "Login success");
    }
    @Step("Logout")
    @Test
    public void logout(){
        loginPage.openSite("https://my.monkkee.com/#/");
        loginPage.LogIn(NAME, PASSWORD);
        loginPage.logout();
        assertTrue(loginPage.getLoginButton().isDisplayed(),"You didn't Logout");
    }
}
