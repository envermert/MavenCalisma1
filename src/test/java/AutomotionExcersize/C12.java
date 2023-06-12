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

import java.time.Duration;

public class C12 {






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

        //4. 'Ürünler' düğmesini tıklayın
        driver.findElement(By.cssSelector("[href='/products']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();

        //6. 'Alışverişe Devam Et' düğmesini tıklayın
        driver.findElement(By.cssSelector("div[class='modal-footer']")).click();
        //7. Fareyle ikinci ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[4]")).click();
        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("(//p[@class='text-center'])[2]")).click();

        //9. Her iki ürünün de Sepete eklendiğini doğrulayın
       WebElement first = driver.findElement(By.cssSelector("[href='/product_details/1']"));
        System.out.println("Ilk Urun :"+first.getText());
        WebElement second = driver.findElement(By.cssSelector("[href='/product_details/2']"));
        System.out.println("Ikinci Urun :"+second.getText());

        //10. Fiyatlarını, miktarlarını ve toplam fiyatlarını doğrulayın


    }
}