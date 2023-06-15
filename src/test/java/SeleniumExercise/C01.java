package SeleniumExercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase;

public class C01 extends TestBase {
    @Test
    public void test01() {

        //Chrome tarayıcının konumunu yerel makineden ayarla
        // Tarayıcıyı başlat
        // url'ye git
        driver.get("https://demoqa.com/frames");

        // Sayfadaki toplam iframe sayısını bulun
        int iframeSayi = driver.findElements(By.xpath("//iframe")).size();
        System.out.println(iframeSayi);
        // Sayfadaki toplam iframe'leri yazdır
        System.out.println(iframeSayi);
        // index=0 kullanarak ilk kareye geç
        driver.switchTo().frame("frame1");

        String iframe = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        System.out.println(iframe);

    }
}
