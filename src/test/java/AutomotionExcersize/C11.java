package AutomotionExcersize;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C11 {


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void name() {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("https://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actual = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(actual.isDisplayed());

        //4. 'Sepet' düğmesine tıklayın
        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

        //5. Altbilgiye doğru aşağı kaydırın
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //6. 'ABONELİK' metnini doğrulayın

        WebElement subscription =  driver.findElement(By.xpath("(//h2)[1]"));
        System.out.println(subscription.getText());
        Assert.assertTrue(subscription.isDisplayed());

        //7. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
        driver.findElement(By.cssSelector("#susbscribe_email")).sendKeys("envermert@gmail.com",Keys.ENTER);

        //8. Başarı mesajını doğrulayın 'Başarılı bir şekilde abone oldunuz!' görünür
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='alert-success alert']")).isDisplayed());
    }
}
