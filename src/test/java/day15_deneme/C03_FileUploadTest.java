package day15_deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase;

public class C03_FileUploadTest extends TestBase {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        String dosyaYolu = "/Users/enver/Desktop/Ekran Resmi 2023-06-19 20.54.52.png";
        //dosyaSeç butonuna basalim
        WebElement dosyaSec = driver.findElement(By.xpath("(//input)[1]"));
        dosyaSec.sendKeys(dosyaYolu);

        //Yuklemek istediginiz dosyayi secelim.
dosyaSec.sendKeys(dosyaYolu);
bekle(2);
        //Upload butonuna basalim.
        driver.findElement(By.xpath("(//input)[2]")).click();
        bekle(2);
        //"File Uploaded!" textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
