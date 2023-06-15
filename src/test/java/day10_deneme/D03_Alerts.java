package day10_deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase;

public class D03_Alerts extends TestBase {
    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //Click Button to see alert karsisindaki butona tiklayalim
        driver.findElement(By.xpath("(//button)[2]")).click();
        //Cikan Alert'te You clicked a button yazisinin ciktigini dogrulayalim
        //Ve alert'u kapatalim
        System.out.println("Uyarinin ustenindeki Yazi :"+getTextAlert());

        Assert.assertEquals("You clicked a button",getTextAlert());
        bekle(3);

        acceptAlert();


    }

    @Test
    public void test02() {
        // On button click, confirm box will appear karsisindaki buttona basalim
        driver.findElement(By.xpath("(//button)[3]")).click();

        //Cikan alertte iptal;e basalim
        driver.switchTo().alert().dismiss();

        //Sonuc yazisinda You selected Cancel yazdigini dogrulayalim
        WebElement sonucYazinda = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        String expected = "You selected Cancel";
        Assert.assertEquals(sonucYazinda.getText(),"You selected Cancel");



    }

    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");
        //On button click, prompt box will appear karşısındaki butona tıklayalım
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//button)[5]")).click();
        bekle(2);
        //çıkan alerte ismimizi girelim
        sendKeysAlert("BJK");
        bekle(2);
        acceptAlert();
        //ismi girdiğimizi doğrulayalım
        String sonucYazisi = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("BJK"));


    }
}
