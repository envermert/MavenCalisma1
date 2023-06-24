package day18_deneme;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities1.TestBase;

public class C03_TumSayfaResmi extends TestBase {
    @Test
    public void name() {

    //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

   bekle(2);
    //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

    //Ve ekran görüntüsünü alalım
    tumSayfaResmi();
}
}