package Lesson14.tests;

import Lesson14.pages.MainPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.uncommons.reportng.HTMLReporter;

import java.util.concurrent.TimeUnit;

@Listeners({HTMLReporter.class})
public class BaseTest {

    private static final Logger LOG = Logger.getLogger(BaseTest.class);
    private WebDriver driver;

    @BeforeClass
    public WebDriver startBrowser() {
        LOG.warn("start, 'startBrowser'");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOG.warn("finish, 'startBrowser'");
        return driver;
    }

    protected MainPage navigate(String url) {
        LOG.info("start, 'navigate;");
        driver.get(url);
        LOG.info("finish, 'navigate;");
        return new MainPage(driver);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}