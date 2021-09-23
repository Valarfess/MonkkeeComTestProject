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

    @FindBy(id = "//a[@id='create-entry']")
    private WebElement createEntry;

    @FindBy(xpath = "//a[@title='Delete selected entries']")
    private WebElement deleteEntry;

    @FindBy(xpath = "//a[@title='Print selected entries']")
    private WebElement printEntry;

    @FindBy(xpath = "//div[@id='editable']")
    private WebElement editable;

    @FindBy(xpath = "//i[@class='icon-home']")
    private WebElement home;

    @FindBy(xpath = "//input[@ng-model='model.checked[entry.id]']")
    private WebElement checkBox;

    public WebElement getCheckBox() {
        return checkBox;
    }

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String createNewNote(String text) {
        driver.findElement(By.xpath("//a[@id='create-entry']")).click();
        driver.findElement(By.xpath("//div[@id='editable']")).click();
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
        editable.sendKeys(text);
        home.click();
        return text;
    }

    public void deleteEntry() {
        driver.findElement(By.xpath("//input[@ng-model='model.checked[entry.id]']")).click();
        driver.findElement(By.xpath("//a[@title='Delete selected entries']")).click();
        driver.switchTo().alert().accept();
    }
}
