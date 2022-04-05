package Lesson15;

import Lesson15.pages.MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {


    protected WebDriver driver;

    @BeforeClass
    public WebDriver startBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        return driver;
    }


    protected MainPage navigate(String url) {

        driver.get(url);

        return new MainPage(driver);
    }
}
