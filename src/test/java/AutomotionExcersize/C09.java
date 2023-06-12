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
import java.util.List;

public class C09 {

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

        //4. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        WebElement allProducts = driver.findElement(By.cssSelector("h2[class='title text-center']"));
        Assert.assertTrue(allProducts.isDisplayed());

        //6. Arama girişine ürün adını girin ve ara düğmesine tıklayın

        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Tshirt", Keys.ENTER);
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

        //7. "ARALAN ÜRÜNLER"in görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//div[@class='product-overlay']")).isDisplayed());
        driver.navigate().back();

        // 8. Arama ile ilgili tüm ürünlerin görünür olduğunu doğrulayın

        List<WebElement> urunlerList = driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-justified']"));
        for (WebElement w : urunlerList) {
            System.out.println(w.isDisplayed());
        }

        //9.Arama ile ilgili tum urunlerin basliklarini yazdir.
        for (int i = 0; i < urunlerList.size(); i++) {
            urunlerList = driver.findElements(By.xpath("//i[@class='fa fa-plus-square']"));
            urunlerList.get(i).click();
            System.out.println(driver.findElement(By.xpath("(//h2)[3]")).getText());
            driver.navigate().back();


        }

    }
}