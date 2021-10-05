package ui;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Log4j2
public class BasePage {

    static WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button/div[contains(text(),'Cancel') and @class='btn-text-content']")
    protected static WebElement cancelBtn;
    @FindBy(xpath = "//div[@class='modal-content']")
    protected static List<WebElement> stuckWindow;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 7);
    }

    public void feedBackWindowKill() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();

    }
}
