package Lesson15;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Lesson15.pages.MailBoxPage;
import Lesson15.pages.MainPage;

public class LoginTest extends BaseTest {


    @Test
    public void doLogin() {

        MainPage mainPage = navigate(MainPage.URL);

        MailBoxPage mailBox = mainPage.login("daniel_defo@internet.ru", "iiYiYyoPM31;");

        mailBox.sendEmail("daniel_defo@internet.ru", "Interesting topic", "EMAIL_TEXT");

        String titleEmail = mailBox.waitForEmail("Interesting topic");
        assertTrue(titleEmail.contains("Interesting topic"));

    }
}