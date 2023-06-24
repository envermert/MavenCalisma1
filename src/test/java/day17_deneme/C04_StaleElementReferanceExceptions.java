package day17_deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities1.TestBase;

import java.util.List;

public class C04_StaleElementReferanceExceptions extends TestBase {

    @Test
    public void test01() {
        //techproeducation adresine git
        driver.get("https://techproeducation.com");
        bekle(2);

        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
        driver.navigate().refresh();  //sayfa yenilmesi yaptigimiz icin locate bayatladi. org.openqa.selenium.StaleElementReferenceException: hata aldil.
        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim

        Assert.assertTrue(driver.getTitle().contains("qa") );
    }

    @Test
    public void test02() {

        //techproeducation adresine git
        driver.get("https://techproeducation.com");
        bekle(2);

        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
        driver.navigate().refresh();  //sayfa yenilmesi yaptigimiz icin locate bayatladi. org.openqa.selenium.StaleElementReferenceException: hata aldil.
        driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim

        Assert.assertTrue(driver.getTitle().contains("qa") );
    }

    @Test
    public void test03() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        aramaKutusu.sendKeys("developer",Keys.ENTER);

        driver.navigate().back();
        //driver.navigate().forward();
        /*
        org.openqa.selenium.StaleElementReferenceException: back-forward sonrasinda da bu hatayi aldik
         */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test04() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);

        //çıkan sonuclardan ilk beşine tıklayıp,her ürünün başlığını konsola yazdıralım
       List<WebElement> urunlerList =  driver.findElements(By.xpath("//h2//a"));

        for (int i = 0; i <5 ; i++) {
            urunlerList.get(i).click();
            bekle(2);
            System.out.println(driver.getTitle());
            driver.navigate().back();
            bekle(2);

            urunlerList=driver.findElements(By.xpath("//h2//a"));
        }
    }
}
