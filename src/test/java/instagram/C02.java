package instagram;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase;

import java.awt.*;

public class C02 extends TestBase {
    @Test
    public void test01() {
        //instagram.com adresine git
        driver.get("https://instagram.com");
        //kullanici adi ve  sifre gir "GIRIS yap" a tikla (kullanici =creamteamo7- sifre=mehmet)

       // driver.findElement(By.xpath("(//input)[1]")).sendKeys("cremg0707", Keys.TAB, "280599", Keys.ENTER);
        //driver.findElement(By.xpath("(//input)[1]")).sendKeys("creamteamo7",Keys.TAB,"mehmet",Keys.ENTER);
        driver.findElement(By.xpath("(//input)[1]")).sendKeys("cremg0707",Keys.TAB,"280599",Keys.ENTER);
        bekle(2);
        //Sol tarafta bulunan bildirimler sekmesine tikla
        driver.findElement(By.xpath("//span[@aria-describedby=':r7:']")).click();
        bekle(2);
        //Takip isteğini kabul et
        driver.findElement(By.xpath("(//div[@class='_aacl _aaco _aacw _aad6 _aade'])[1]")).click();
        bekle(2);
        driver.findElement(By.xpath("(//div[@class='_aacl _aaco _aacw _aad6 _aade'])[2]")).click();

        driver.findElement(By.xpath("(//div[@class='x9f619 xxk0z11 xii2z7h x11xpdln x19c4wfv xvy4d1p'])[8]")).click();

        String dosyaYolu="/Users/enver/Desktop/amazonwebpag.png";

        WebElement dosyaYukle = driver.findElement(By.xpath("(//button)[2]"));
        dosyaYukle.sendKeys(dosyaYolu);





        //Takip isteğinin kabul edildiğini doğrula

    }
}