package homeWork11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities1.TestBase;

public class C02 extends TestBase {
    @Test
    public void test01() {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("(//button)[2]")).click();

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(5);
        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();

        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
           driver.findElement(By.cssSelector("a[href='#Textbox']")).click();
           driver.findElement(By.xpath("(//button)[4]")).click();

        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Enver");
        driver.switchTo().alert().accept();

        //-Çıkan mesajı konsola yazdırınız
       String mesaj= driver.findElement(By.cssSelector("p[id='demo1']")).getText();
       System.out.println(mesaj);


        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığınıdoğrulayınız
        String expected="Hello Enver How are you today";
        Assert.assertEquals(expected,driver.findElement(By.cssSelector("p[id='demo1']")).getText());
    }


}
