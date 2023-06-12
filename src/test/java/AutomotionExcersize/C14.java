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

import javax.security.auth.kerberos.KeyTab;
import java.security.Key;
import java.time.Duration;

public class C14 {

    //1. Tarayıcıyı başlatın
    static WebDriver driver;

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
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actual = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(actual.isDisplayed());
        //4. Sepete ürün ekleyin
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        driver.navigate().back();
        driver.navigate().forward();
        //5. 'Sepet' düğmesine tıklayın
        driver.findElement(By.cssSelector("button[type='button']")).click();
        //6. Sepet sayfasının görüntülendiğini doğrulayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();
        String ShoppingCart = driver.findElement(By.cssSelector("ol[class='breadcrumb']")).getText();
        Assert.assertEquals(ShoppingCart,"Home Shopping Cart");

        //7. Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.cssSelector("a[class='btn btn-default check_out']")).click();

//        //8. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("(//a[@href='/login'])[2]")).click();
        //9. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("enver", Keys.TAB,"enver21@gmail.com",Keys.ENTER);

        //10. 'HESAP OLUŞTURULDU!'nu doğrulayın! ve 'Devam Et' düğmesini tıklayın
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


        //11. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        String verifiy = driver.findElement(By.xpath("//b[.='Account Created!']")).getText();
        Assert.assertEquals(verifiy,"ACCOUNT CREATED!");


        //12.'Sepet' düğmesine tıklayın
        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

        //13. 'Ödeme İşlemine Devam Et' düğmesini tıklayın
      //  driver.findElement(By.cssSelector("a[href='/payment']")).click();
        driver.findElement(By.cssSelector("a[class='btn btn-default check_out']")).click();

        //14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin

        String adresDogrulama = driver.findElement(By.xpath("(//h2[@class='heading'])[1]")).getText();
        Assert.assertEquals("Address Details",adresDogrulama);
        //15. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Urunleri komsuya birakalbilirsiniz",Keys.TAB,Keys.ENTER);

        //16. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        driver.findElement(By.cssSelector("input[class='form-control']")).sendKeys("Enver Mert",Keys.TAB,"434256475327",Keys.TAB,"123",Keys.TAB,"12",Keys.TAB,"2023");

        //17. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        driver.findElement(By.cssSelector("button[class='form-control btn btn-primary submit-button']")).click();

        //18. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
       String  basariMesaji=  driver.findElement(By.cssSelector("h2[class='title text-center']")).getText();
       Assert.assertEquals(basariMesaji,"ORDER PLACED!");

        //19. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();

        //20. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
       driver.findElement(By.cssSelector("div[class='pull-right']")).click();





    }




}

