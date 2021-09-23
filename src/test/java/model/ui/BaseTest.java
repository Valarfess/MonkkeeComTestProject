package model.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public static final String NAME = "valarfess@gmail.com";
    public static final String PASSWORD = "Valar211922";
    public WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeMethod
    public void setUP (){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("disable-popup-blocking");
//        chromeOptions.addArguments("headless");
//        driver = new ChromeDriver(chromeOptions);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,5);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void exit(){
        driver.close();
    }
}

