package AutomotionExcersize;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C10 {


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("https://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actual = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(actual.isDisplayed());

        //4. Altbilgiye doğru aşağı kaydırın
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //5. 'KUAYIT' metnini doğrulayın'
        WebElement subscription = driver.findElement(By.xpath("(//h2)[82]"));
        System.out.println(subscription.getText());
        Assert.assertTrue(subscription.isDisplayed());

        //6. E-posta adresini girişe girin ve ok düğmesini tıklayın
        driver.findElement(By.cssSelector("#susbscribe_email")).sendKeys("envermert@gmail.com",Keys.ENTER);

        //7. Başarı mesajını doğrulayın 'Başarılı bir şekilde abone oldunuz!' görünür
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='alert-success alert']")).isDisplayed());

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
