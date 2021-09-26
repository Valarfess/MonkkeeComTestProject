package model.ui;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;


@Log4j2
public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@title='Create an entry']")
    private WebElement createEntry;

    @FindBy(xpath = "//a[@title='Delete selected entries']")
    private WebElement deleteEntry;

    @FindBy(xpath = "//a[@title='Print selected entries']")
    private WebElement printEntry;

    @FindBy(xpath = "//div[@id='editable']")
    private WebElement editable;

    @FindBy(xpath = "//a[@title='Back to overview']")
    private WebElement home;

    @FindBy(xpath = "//input[@title='Select all']")
    private WebElement checkBox;

    public WebElement getCheckBox() {
        return checkBox;
    }

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String createNewNote(String text) {
        createEntry.click();
        editable.click();
        editable.sendKeys(text);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        home.click();
        return text;
    }

    public void deleteEntry() {
        checkBox.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        deleteEntry.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.switchTo().alert().accept();
    }
}
