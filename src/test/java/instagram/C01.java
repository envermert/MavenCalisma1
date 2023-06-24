package instagram;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities1.TestBase;

public class C01 extends TestBase {
    @Test
    public void instagram () {
        //instagram.com adresine git
        driver.get("https://instagram.com");
        //kullanici adi ve  sifre gir "GIRIS yap" a tikla (kullanici =creamteamo7- sifre=mehmet)
        WebElement kullaniciAdi = driver.findElement(By.xpath("(//input)[1]"));
        kullaniciAdi.sendKeys("creamteamo7",Keys.TAB,"mehmet",Keys.TAB,Keys.ENTER);
        driver.findElement(By.xpath("//button[@class='_acan _acap _acas _aj1-']")).click();
        //Sol tarafta bulunan profil sekmesine tikla
        driver.findElement(By.xpath("(//span[@class='x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft'])[8]")).click();
        //Cikan sayfa ilk fotografa tikla
        driver.findElement(By.xpath("(//div[@class='_aagw'])[1]")).click();

        //Begen (kalp) tusuna tikla,
        driver.findElement(By.xpath("(//div[@class='_abm0 _abl_'])[2]")).click();
        //Begeni sayisini yazdir.
        String begenSayisi1 = driver.findElement(By.xpath("(//a[@role='link'])[26]")).getText();
        System.out.println("Begenme Sayisi ="+begenSayisi1);
        //Paylasim zamanini test et.
        String begen1 = driver.findElement(By.xpath("//time[@class='_aaqe']")).getText();
        System.out.println("Paylasim zamanini ="+begen1);
        //Yorum ekle
        driver.findElement(By.xpath("//textarea[@aria-label='Yorum ekle...']")).sendKeys("Tebrikler :)",Keys.ENTER);
        //driver.findElement(By.xpath("(//div[@class='_adkq'])[104]")).sendKeys("zar",Keys.TAB,Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k'])[2]")).click();


        //kaydet butonuna tikla
        driver.findElement(By.xpath("(//button[@class='_abl-'])[7]")).click();



        //Sonra resimdeki ileri Tusa tikla Diger resime gec.
        driver.findElement(By.xpath("(//div[@class='_abm0'])[2]")).click();
        //Begen (kalp) tusuna tikla,
        driver.findElement(By.xpath("(//div[@class='_abm0 _abl_'])[2]")).click();

        //Begeni sayisini yazdir.
        String begenSayisi2 = driver.findElement(By.xpath("(//a[@role='link'])[26]")).getText();
        System.out.println("Begenme Sayisi1 ="+begenSayisi2);
        //Paylasim zamanini test et.
        String begen2 = driver.findElement(By.xpath("//time[@class='_aaqe']")).getText();
        System.out.println("Paylasim zamanini ="+begen2);
        //Yorum ekle
        driver.findElement(By.xpath("//textarea[@aria-label='Yorum ekle...']")).sendKeys("Muhtesem:)",Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k'])[2]")).click();

        //kaydet butonuna tikla
        driver.findElement(By.xpath("(//button[@class='_abl-'])[7]")).click();

        //Kapat X tusuna tikla
         driver.findElement(By.xpath("(//div[@class='x6s0dn4 x78zum5 xdt5ytf xl56j7k'])[1]")).click();
    }

}
