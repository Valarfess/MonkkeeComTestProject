package model.ui;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


@Log4j2
public class HomePage extends BasePage {

    @FindBy(xpath = "//i[@class='icon-plus']")
    private WebElement createEntry;

    @FindBy(xpath = "//a[@title='Delete selected entries']")
    private WebElement deleteEntry;

    @FindBy(xpath = "//div[@id='editable' and @contenteditable='true']")
    private WebElement editable;

    @FindBy(xpath = "//i[@class='icon-home']")
    private WebElement home;

    @FindBy(xpath = "//input[@title='Select all' and @type='checkbox']")
    private WebElement checkBox;

    @FindBy(xpath = "//input[@ng-model='model.checked[entry.id]']")
    private WebElement checkBoxForAssert;

    public WebElement getCheckBoxForAssert() {
        return checkBoxForAssert;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String createNote(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(createEntry)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editable)).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(editable)).sendKeys(text);
        wait.until(ExpectedConditions.elementToBeClickable(home)).click();
        return text;
    }

    public void deleteNote() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(deleteEntry)).click();
        driver.switchTo().alert().accept();
    }
}
