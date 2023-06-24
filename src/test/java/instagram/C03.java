package instagram;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities1.TestBase;

public class C03 extends TestBase {

    @Test
    public void instagram() {

            //instagram.com adresine git
            driver.get("https://instagram.com");
            //kullanici adi ve  sifre gir "GIRIS yap" a tikla (kullanici =creamteamo7- sifre=mehmet)

            //Kaydol butonuna tikla
        driver.findElement(By.xpath("//a[@href='/accounts/emailsignup/']")).click();

        //e-posto - adi Soyadi - kullanici adi - sifre
       WebElement bilgiler =  driver.findElement(By.xpath("//input[@aria-label='Cep Telefonu Numarası veya E-posta']"));
        bilgiler.sendKeys("mert.enver@gmail.com",Keys.TAB,"Mert",Keys.TAB,"Enver",Keys.TAB,"1986");

    }
}