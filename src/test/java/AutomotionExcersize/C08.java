package AutomotionExcersize;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C08 {

    //1. Tarayıcıyı başlatın
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void tarayici() throws InterruptedException {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("https://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actual = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(actual.isDisplayed());
        //System.out.println(driver.findElement(By.xpath("//div[@class='logo pull-left']")).isDisplayed());

        //4. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        WebElement allProducts = driver.findElement(By.cssSelector("h2[class='title text-center']"));
        Assert.assertTrue(allProducts.isDisplayed());

        //6. Ürün listesi görünür

        WebElement urunlerListesi = driver.findElement(By.xpath("(//ul[@class='nav nav-pills nav-justified'])[position()>=1 and position()<=34]"));
        Assert.assertTrue(urunlerListesi.isDisplayed());

        //7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        driver.findElement(By.cssSelector(" [href='/product_details/1']")).click();

        //8. Kullanıcı ürün detay sayfasına yönlendirildi
        WebElement urun = driver.findElement(By.xpath("(//img[@alt='ecommerce website products'])[1]"));
        Assert.assertTrue(urun.isDisplayed());


        //9. Ürün adı, kategorisi, fiyatı, bulunabilirliği, durumu, markası gibi ayrıntıların göründüğünü doğrulayın.
        driver.findElement(By.xpath("//section[@style='height: auto !important;']")).isDisplayed();

    }








}






