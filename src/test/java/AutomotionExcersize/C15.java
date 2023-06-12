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
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.Duration;

public class C15 {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("https://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement AnaSayfa = driver.findElement(By.cssSelector("div[class='col-sm-4']"));
        Assert.assertTrue(AnaSayfa.isDisplayed());

        //4. 'Kaydol / Giriş Yap' düğmesini tıklayın
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //5. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Enver",Keys.TAB,"denver.enver@gmail.com",Keys.ENTER);

        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("1234",Keys.TAB);

        WebElement day = driver.findElement(By.xpath("//select[@data-qa='days']"));
        Select select = new Select(day);
        select.selectByVisibleText("19");

        WebElement ay =driver.findElement(By.cssSelector("select[data-qa='months']"));
        Select select1 = new Select(ay);
        select1.selectByValue("9");

        WebElement yil = driver.findElement(By.cssSelector("select[data-qa='years']"));
        Select select2 = new Select(yil);
        select2.selectByVisibleText("1986");

        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("enver",Keys.TAB,"mert",Keys.TAB,"Besiktas",Keys.TAB,"Houston",Keys.TAB,"Texas");

        WebElement country = driver.findElement(By.cssSelector("select[data-qa='country']"));
        Select select3 = new Select(country);
        select3.selectByVisibleText("Canada");

        driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("Ottowa",Keys.TAB,"vancouver",Keys.TAB,"77076",Keys.TAB,"05538073008",Keys.ENTER);

        //6. 'HESAP OLUŞTURULDU!'nu doğrulayın. ve 'Devam Et' düğmesini tıklayın
        String dogrulama =driver.findElement(By.xpath("(//h2)[1]")).getText();
        Assert.assertEquals(dogrulama,"ACCOUNT CREATED!");

        driver.findElement(By.cssSelector("div[class='pull-right']")).click();

        driver.navigate().back();
        driver.navigate().forward();

        //7. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        String kullaniciAdi = driver.findElement(By.cssSelector("i[class='fa fa-user']")).getText();
        kullaniciAdi.contains("Enver");

        //8. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();

        //9. 'Sepet' düğmesine tıklayın
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //10. Sepet sayfasının görüntülendiğini doğrulayın
        String sepetSayfasi = driver.findElement(By.cssSelector("div[class='breadcrumbs']")).getText();
        Assert.assertTrue(sepetSayfasi.contains("Home Shopping Cart"));

        //11. Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.cssSelector("a[class='btn btn-default check_out']")).click();

        //12. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        driver.findElement(By.xpath("(//h2[@class='heading'])[1]")).isDisplayed();

        //13. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.cssSelector("textarea[class='form-control']")).sendKeys("Merhaba ben enver");
        driver.findElement(By.cssSelector("a[class='btn btn-default check_out']")).click();
        //14. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        //15. 'Öde ve Siparişi Onayla' düğmesine tıklayın

        driver.findElement(By.cssSelector("input[class='form-control']")).sendKeys("Enver Mert",Keys.TAB,"324723426",Keys.TAB,"222",Keys.TAB,"11",Keys.TAB,"2022",Keys.ENTER);


        //16. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        driver.findElement(By.cssSelector("h2[class='title text-center']")).isDisplayed();
        driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();

        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
        //18. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
        driver.findElement(By.cssSelector("div[class='pull-right']")).click();


    }


}
