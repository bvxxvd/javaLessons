package Lesson14.tests;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.util.Date;

import Lesson14.pages.MailBoxPage;
import Lesson14.pages.MainPage;
import Lesson14.pages.EmailForm;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(LoginTest.class);
    public static final String DATA = new Date().toString();
    private static final String EMAIL_TEXT = "Письмо самому себе." + DATA;
    protected final WebDriver driver;

    public LoginTest(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void doLogin() {

        LOG.warn("start: navigate");
        MainPage mainPage = navigate(MainPage.URL);
        LOG.warn("start: login");
        LOG.info("enter: daniel_defo@internet.ru  iiYiYyoPM31;");
        MailBoxPage mailBox = mainPage.login("daniel_defo@internet.ru", "iiYiYyoPM31;");

        EmailForm email = mailBox.getEmailForm();
        LOG.info("send Email;");
        email.sendEmail("daniel_defo@internet.ru", "Тест", EMAIL_TEXT);

        MailBoxPage mailBoxCheck = email.backInBox();

        String s = driver.findElement(By.xpath("//span[text()='Тест']")).getText();
        assertEquals("Тест", s);     // проверка значения

//        LOG.info("check Email;");
//        String titleEmail = mailBoxCheck.waitForMyEmail(EMAIL_TEXT);
//        assertTrue(titleEmail.contains(EMAIL_TEXT));
//        LOG.info("check OK;");
//        closeBrowser();
    }
}

//@Test
//    @DisplayName("Тест-кейс №1: Проверка правильности отображения номера телефона на главной странице")
//    public void testCase1() {
//        // тестовые действия
//        driver.get("https://andersenlab.com/");
//        String s = driver.findElement(By.xpath("//span[contains(@class,'phoneNumber')]")).getText();
//        assertEquals("+48 22 390 64 08", s);     // проверка значения
//
//        //результат теста
//        logger.info("Тест-кейс №1 пройден");      // выведется только если тест не упадет и условия соблюдены
//    }