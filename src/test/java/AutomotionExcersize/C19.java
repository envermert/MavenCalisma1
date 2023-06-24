package AutomotionExcersize;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase;

public class C19 extends TestBase {
    @Test
    public void test01() {

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);

        //4. Sol taraftaki çubukta Markaların göründüğünü doğrulayın
        assert driver.findElement(By.xpath("(//h2)[2]")).isDisplayed();

        //5. Herhangi bir marka adına tıklayın
        driver.findElement(By.xpath("(//span[@class='pull-right'])[2]")).click();

        //6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın.
        assert driver.findElement(By.xpath("(//h2)[3]")).isDisplayed();

        //7. Sol taraftaki çubukta herhangi bir başka marka bağlantısına tıklayın
        driver.findElement(By.xpath("(//span[@class='pull-right'])[3]")).click();

        //8. Kullanıcının o marka sayfasına gittiğini ve ürünleri görebildiğini doğrulayın
        assert driver.findElement(By.xpath("(//h2)[3]")).isDisplayed();
    }
}
