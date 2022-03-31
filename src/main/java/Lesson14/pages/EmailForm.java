package Lesson14.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailForm extends BasePage {

    private static final String TO_WHOM = "//div[contains(@class, 'head_container')]//input";
    private static final String TOPIC = "//div[contains(@class, 'subject__container')]//input";
    private static final String TEXT = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]";
    private static final String SEND_BUTTON = "//span[text()='Отправить']";
    private static final String INBOX = "//div[text()='Входящие']";

    public EmailForm(WebDriver driver) {
        super(driver);
    }

    public void sendEmail(String toWhom, String subject, String text) {
        WebElement toWhomField = getDriver().findElement(By.xpath(TO_WHOM));
        toWhomField.click();
        toWhomField.sendKeys(toWhom);
        WebElement subjectField = getDriver().findElement(By.xpath(TOPIC));
        subjectField.click();
        subjectField.sendKeys(subject);
        WebElement textField = driver.findElement(By.xpath(TEXT));
        textField.click();
        textField.sendKeys(Keys.CONTROL + "a");
        textField.sendKeys(Keys.DELETE);
        textField.sendKeys(Keys.ENTER);
        textField.sendKeys(text);
        getDriver().findElement(By.xpath(SEND_BUTTON)).click();
    }

    public MailBoxPage backInBox() {
        getDriver().findElement(By.xpath(INBOX)).click();
        return new MailBoxPage(driver);
    }
}