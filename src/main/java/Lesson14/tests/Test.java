package Lesson14.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://mail.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement enterButton = driver.findElement(By.xpath("//button[text()='Войти' and contains (@class,'ph-login')]"));
        enterButton.click();

        //переключаемся во фрейм
        driver.switchTo().frame(1);

        WebElement accountNameField = driver.findElement(By.xpath("//div[@id='root']/descendant::input[@name='username']"));
        accountNameField.sendKeys("daniel_defo@internet.ru");
        WebElement enterPasswordButton = driver.findElement(By.xpath("//span[text()='Enter password']"));
        enterPasswordButton.click();
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("iiYiYyoPM31;");
        WebElement signInButton = driver.findElement(By.xpath("//span[text()='Sign in']"));
        signInButton.click();

        //возвращается в окно
        driver.switchTo().defaultContent();

        WebElement composeLetter = driver.findElement(By.xpath("//span[text()='Написать письмо']"));
        composeLetter.click();
        WebElement toWhomField = driver.findElement(By.xpath("//div[contains(@class, 'head_container')]//input"));
        toWhomField.sendKeys("daniel_defo@internet.ru");
        WebElement subjectField = driver.findElement(By.xpath("//div[contains(@class, 'subject__container')]//input"));
        subjectField.sendKeys("Тест");
        WebElement textField = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]"));
        textField.sendKeys("Письмо самому себе.");
        WebElement sendButton = driver.findElement(By.xpath("//span[text()='Отправить']"));
        sendButton.click();
    }
}


