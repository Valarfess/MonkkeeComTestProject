package model.ui;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class BasePage {

    static WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button/div[contains(text(),'Cancel')]")
    protected static WebElement cancelBtn;
    @FindBy (xpath = "//div[@class='modal-content']")
    protected static WebElement stuckWindow;


    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,7);
    }

//    public static void feedBackWindowKill(){
//            WebDriverWait wait = new WebDriverWait(driver,7);
//            wait.until(ExpectedConditions.visibilityOf(cancelBtn)).click();
//            cancelBtn.click();
//    }
}
