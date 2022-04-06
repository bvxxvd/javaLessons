package Lesson13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW13Test {

    static WebDriver driver;
    Logger logger = LoggerFactory.getLogger("Test-Cases");

    @BeforeAll
    static void initClass() {
        // Инициализация веб драйвера
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @AfterAll
    static void finalClass() {
        // Закрытие драйвера
        driver.quit();
    }

    @Test
    @DisplayName("Тест-кейс №1: Проверка правильности отображения номера телефона на главной странице")
    public void testCase1() {
        // тестовые действия
        driver.get("https://andersenlab.com/");
        String s = driver.findElement(By.xpath("//span[contains(@class,'phoneNumber')]")).getText();
        assertEquals("+48 22 390 64 08", s);     // проверка значения

        //результат теста
        logger.info("Тест-кейс №1 пройден");      // выведется только если тест не упадет и условия соблюдены
    }

    @Test
    @DisplayName("Тест-кейс №2: Проверка правильности отображения электронной почты на главной странице")
    public void testCase2() {
        // тестовые действия
        driver.get("https://andersenlab.com/");
        String s = driver.findElement(By.xpath("//span[contains(@class,'mail')]")).getText();
        assertEquals("vn@andersenlab.com", s);     // проверка значения

        //результат теста
        logger.info("Тест-кейс №2 пройден");      // выведется только если тест не упадет и условия соблюдены
    }
}
