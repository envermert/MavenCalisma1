package day12_deneme;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities1.TestBase;

import java.io.File;
import java.io.IOException;
import java.security.Key;

public class C02_BasicAuthentication extends TestBase {

    @Test
    public void test01() {

        //Url: https://the-internet.herokuapp.com/basic_auth
        // Username: admin
        // Password: admin

        // Başarılı girişi doğrulayın.
            driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Başarılı bir girişten sonra Congratulations! yazısının cıktıgını test edınız
//        WebElement text = driver.findElement(By.xpath("//p"));
//        Assert.assertTrue(text.getText().contains("Congratulations!"));
        //2.yol
        assert driver.findElement(By.xpath("//p")).getText().contains("Congratulations!");

        //Elemental Selenium yazisina tiklayalim
        driver.findElement(By.xpath("(//a)[2]")).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());//acilan yeni pencereye gecti



        //Basligin "Elemental Selenium" olmadıgını dogrulayin
        System.out.println("Sayfa Basligi :"+driver.getTitle());
        Assert.assertNotEquals("Elemental Selenium :",driver.getTitle());

        //DropDown menuden Javayı secelım
        WebElement ddm = driver.findElement(By.xpath("//select"));



    }
}
