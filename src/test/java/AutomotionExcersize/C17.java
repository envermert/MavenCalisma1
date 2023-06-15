package AutomotionExcersize;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C17 extends TestBase {

    @Test
    public void test01() throws AWTException {

      //1. Tarayıcıyı başlatın

        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actual = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(actual.isDisplayed());

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);

        //4. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
//        driver.navigate().back();
//        driver.navigate().forward();

        //5. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();

        //6. Sepet sayfasının görüntülendiğini doğrulayın
        assert driver.findElement(By.xpath("//li[@class='active']")).isDisplayed();

        //7. Belirli bir ürüne karşılık gelen 'X' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@class='cart_quantity_delete']")).click();

        //8. Ürünün sepetten çıkarıldığını doğrulayın
        System.out.println(driver.findElement(By.xpath("//p//b")).isDisplayed());

    }
}
