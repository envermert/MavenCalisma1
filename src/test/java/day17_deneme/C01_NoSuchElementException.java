package day17_deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities1.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test01() {

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        driver.findElement(By.xpath("//input[@ttype='search']")).sendKeys("qa", Keys.ENTER);
        /*
        org.openqa.selenium.NoSuchElementException: locate yanlis aldigim icin hata verdi ..
         */

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));


    }

    @Test
    public void test02() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        driver.findElement(By.cssSelector("//input[@ttype='search']")).sendKeys("qa", Keys.ENTER);

        //org.openqa.selenium.InvalidSelectorException:  hatasini aldik

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }



}
