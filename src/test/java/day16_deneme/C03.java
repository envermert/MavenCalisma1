package day16_deneme;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities1.TestBase;

import java.time.Duration;

public class C03 extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).//-->FluentWait max. bekleme süresini belirtir
                pollingEvery(Duration.ofMillis(200)).//-->200 milisaniye aralıklarla webelementin etkileşime girdini kontrol et
                withMessage("Webelementi kontrol et");//-->Hata alma durumunda konsolda bu mesajı verir--> Zorunlu değil
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));

    }
}
