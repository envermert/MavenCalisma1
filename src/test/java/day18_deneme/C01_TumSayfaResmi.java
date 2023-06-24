package day18_deneme;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities1.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        String dosyaYolu = "src/test/java/TumSayfaResmi/ScreenShot.png";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }

    @Test
    public void test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE),new File("src/test/java/TumSayfaResmi/ScreenShot.jpeg"));

    }

    @Test
    public void test03() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_hh_mm_ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/TumSayfaResmi/ScreenShot"+tarih+".jpeg";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }

    @Test
    public void test04() throws IOException {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");


        //Ve ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_hh_mm_ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/TumSayfaResmi/ScreenShot"+tarih+".jpeg";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }
}

