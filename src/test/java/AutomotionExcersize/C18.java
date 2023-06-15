package AutomotionExcersize;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase;

public class C18 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1. Tarayıcıyı başlatın

        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Kategorilerin sol taraftaki çubukta göründüğünü doğrulayın
        assert driver.findElement(By.xpath("//div[@class='panel-group category-products']")).isDisplayed();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);

        //4. 'Kadınlar' kategorisine tıklayın
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. "Kadınlar" kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
        driver.findElement(By.xpath("//a[@href='/category_products/1']")).click();
        Thread.sleep(4000);
        driver.navigate().back();
        driver.navigate().forward();

        //6. Kategori sayfasının görüntülendiğini doğrulayın ve 'KADIN - TOPS ÜRÜNLERİ' metnini onaylayın
        assert driver.findElement(By.xpath("(//h2)[3]")).isDisplayed();

        //7. Sol taraftaki çubukta, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısına tıklayın
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[2]")).click();
        driver.findElement(By.xpath("//a[@href='/category_products/3']")).click();

        //8. Kullanıcının o kategori sayfasına yönlendirildiğini doğrulayın
        assert driver.findElement(By.xpath("(//h2)[3]")).isDisplayed();
    }
}
