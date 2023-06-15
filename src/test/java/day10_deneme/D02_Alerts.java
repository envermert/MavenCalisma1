package day10_deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v110.domsnapshot.model.StringIndex;
import utilities1.TestBase;

public class D02_Alerts extends TestBase {
    @Test
    public void acceptAlert() {

        //Bir metod olusturun: acceptAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        driver.switchTo().alert().accept();

        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi = "You successfully clicked an alert";
        Assert.assertEquals(istenenYazi,resultMessage.getText());

    }

    @Test
    public void dismissAlert() {
        //Bir metod olusturun: dismissAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();
        driver.switchTo().alert().dismiss();

        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi = "successfuly";
        Assert.assertFalse(resultMessage.getText().contains(istenenYazi));
    }

    @Test
    public void sendKeysAlert() {

        //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[3]")).click();
        driver.switchTo().alert().sendKeys("Enver");
        driver.switchTo().alert().accept();

        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));
        String istenenMetin = "Enver";
        Assert.assertTrue(resultMessage.getText().contains(istenenMetin));
        bekle(5);
    }



}
