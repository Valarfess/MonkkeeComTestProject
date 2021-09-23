package model.ui;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='login']")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[contains(text(),'Mandatory field')]")
    private WebElement errorMessage;
    @FindBy(xpath = "//div[contains(text(),'Login failed')]")
    private WebElement errorMessage1;

    public WebElement getLoginButton() {
        return loginButton;
    }

    @FindBy(xpath = "//button[@class='user-menu-btn']")
    private WebElement logOutBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public LoginPage LogIn(String userName, String password) {
        userNameField.clear();
        userNameField.sendKeys(userName);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
//        if (stuckWindow.isDisplayed()) {
//            feedBackWindowKill();
//        } else {
//            log.info("All ok! No monkkee-feedback window on this page.");
//        }
        return new LoginPage(driver);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getErrorMessage1() {
        return errorMessage1.getText();
    }

    public LoginPage logout() {
        logOutBtn.click();
        return new LoginPage(driver);
    }
}
