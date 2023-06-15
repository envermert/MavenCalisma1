package SeleniumExercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase;

public class C02 extends TestBase {

    @Test
    public void test01() {
        // yerel makine yolundan krom tarayıcının konumunu ayarla
        // Tarayıcıyı başlat WebDriver sürücüsü=yeni ChromeDriver();
        // Demo sitesine gidin
        driver.get("https://demoqa.com/nestedframes");
        // Sayfadaki Çerçeve Sayısı
        int cerceveSayisi = driver.findElements(By.tagName("iframe")).size();
        System.out.println(cerceveSayisi);
        // frame1'i web sayfasında bulun
        WebElement frame1 = driver.findElement(By.id("frame1"));

        // Frame1'e geç
        driver.switchTo().frame("frame1");

        // Elemanı Frame1'in içine bulun
        WebElement frame1Element = driver.findElement(By.tagName("body"));

        // frame1 elemanı için metni al
        String metin =driver.findElement(By.xpath("//*[.='Parent frame']")).getText();

        //Ana çerçeve içinde bulunan metni Yazdırmayı deneyin
        System.out.println(driver.findElement(By.xpath("//*[.='Parent frame']")).getText());


        //Frame2'e geç
        driver.switchTo().frame(0);

        // Elemanı Frame2'in içine bulun
        WebElement frame2Element = driver.findElement(By.tagName("body"));
        System.out.println(frame2Element.getText());

        // frame2 elemanı için metni al
        String metin2 = driver.findElement(By.xpath("//*[.='Child Iframe']")).getText();

        //Child frame içinde bulunan metni Yazdırmayı deneyin
        System.out.println(metin2);


    }
}
