package homeWork13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase;

public class C01 extends TestBase {
    @Test
    public void test01() {

        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement tablo = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(tablo)
                .moveByOffset(0, -50)
                .clickAndHold()
                .moveByOffset(0, 100)
                .moveByOffset(-60, -90)
                .moveByOffset(120, 0)
                .moveByOffset(-60, 90)
                .moveByOffset(0, -100)
                .moveByOffset(0, -50)
                .clickAndHold()
                .moveByOffset(0, 100)
                .moveByOffset(-60, -90)
                .moveByOffset(120, 0)
                .moveByOffset(-60, 90)
                .moveByOffset(0, -100)
                .moveByOffset(0, -50)
                .clickAndHold()
                .moveByOffset(0, 100)
                .moveByOffset(-60, -90)
                .moveByOffset(120, 0)
                .moveByOffset(-60, 90)
                .moveByOffset(0, -100)
                .moveByOffset(0, -50)
                .clickAndHold()
                .moveByOffset(0, 100)
                .moveByOffset(-60, -90)
                .moveByOffset(120, 0)
                .moveByOffset(-60, 90)
                .moveByOffset(0, -100)
                .moveByOffset(0, -50)
                .clickAndHold()
                .moveByOffset(0, 100)
                .moveByOffset(-60, -90)
                .moveByOffset(120, 0)
                .moveByOffset(-60, 90)
                .moveByOffset(0, -100)
                .release()
                .perform();

        bekle(4);
        //- Çizimden sonra clear butonuna basınız
         driver.findElement(By.xpath("//*[@class='button clear']")).click();
         // Sayfayi kapatiniz
        driver.close();



    }
}



