package day18_deneme;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities1.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_TumSayfaResmi extends TestBase {
    @Test
    public void test01() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Ve ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/TumSayfaResmi/screenShot"+tarih+".jpeg";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),screenshot.getScreenshotAs(OutputType.BYTES));
    }
}