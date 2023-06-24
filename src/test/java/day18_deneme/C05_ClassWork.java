package day18_deneme;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities1.TestBase;

public class C05_ClassWork extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //sayfanın resmini alalım
        tumSayfaResmi();


        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']")).sendKeys("java", Keys.ENTER);


        //ve sonuc yazısının resmini alalım
        WebElement sonucyazisi = driver.findElement(By.xpath("//h1"));

        //methodla resmını aldık
        webElementResmi(sonucyazisi);

        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //sayfanın resmini alalım
        tumSayfaResmi();
        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);



        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi1 = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        webElementResmi(sonucYazisi1);


        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchTo(0);
        tumSayfaResmi();
    }

}
