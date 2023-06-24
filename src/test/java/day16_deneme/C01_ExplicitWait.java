package day16_deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities1.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla

        driver.findElement(By.xpath("//button")).click();


        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));

        Assert.assertEquals(helloWorldText.getText(),"Hello World!");
        //Locate 'ini alldgimiz hellowordlText webelemenitini gorunur olana kadar explicit wait ile bekleyecegim.


        //VisibilityOf methoduyla gorunur olana kadar bekler.

    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla

        driver.findElement(By.xpath("//button")).click();


        //Hello World! Yazının sitede oldugunu test et
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        Assert.assertEquals(driver.findElement(By.xpath("(//h4)[2]")).getText(),"Hello World!");
    }

    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla

        driver.findElement(By.xpath("//button")).click();


        //Hello World! Yazının sitede oldugunu test et

        new WebDriverWait(driver,Duration.ofSeconds(20)).
        until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));

        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());

    }

    @Test
    public void test04() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla

        driver.findElement(By.xpath("//button")).click();


        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText =driver.findElement(By.xpath("(//h4)[2]"));
        //Locate'ini aldigimiz helloWorldText webelementini gorunur olana kadar explicit wait bekleyecegim.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));//-->max.20 saniye belirttik.
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']")));
        //invisibilityOfElementLocated() methodu ile loading webelementi kaybolana kadar bekler.

        Assert.assertEquals("Hello World!",helloWorldText.getText());

    }

}
