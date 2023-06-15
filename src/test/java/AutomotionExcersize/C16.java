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

public class C16 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1() {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actual = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(actual.isDisplayed());
        //4. 'Kaydol / Giriş Yap' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. E-postayı, şifreyi doldurun ve 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("enver.enver@gmail.com", Keys.TAB,"1234",Keys.ENTER);
        //6. En üstte 'Kullanıcı adı olarak oturum açıldı'yı doğrulayın
        Assert.assertEquals(driver.findElement(By.xpath("(//li//a)[10]")).getText(),"Logged in as Rana");
        //7. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//i[@class='fa fa-plus-square'])[3]")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //8. 'Sepet' düğmesine tıklayın
        driver.findElement(By.cssSelector("button[type='button']")).click();
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();
        //9. Sepet sayfasının görüntülendiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='active']")).isDisplayed());

        //10. Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //11. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        assert driver.findElement(By.cssSelector("#address_delivery")).isDisplayed();
        assert driver.findElement(By.xpath("//table[@class='table table-condensed']")).isDisplayed();
        //12. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("açıklama",Keys.TAB,Keys.ENTER);
        //13. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        //14. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        driver.findElement(By.xpath("(//input)[2]")).sendKeys("RANA",Keys.TAB,"5282020029365164",Keys.TAB,"624",Keys.TAB,"11",Keys.TAB,"2027",Keys.ENTER);


        //15. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        assert driver.findElement(By.xpath("//h2")).isDisplayed();
        //16. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();

        //18. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
        String silindi=driver.findElement(By.xpath("//h2//b")).getText();
        Assert.assertEquals(silindi,"ACCOUNT DELETED!");
    }

}
