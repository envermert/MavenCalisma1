package homeWork14;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase;

public class C01 extends TestBase {
    @Test
    public void test01() {

            //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
            driver.get("https://jqueryui.com/slider/#colorpicker");

            //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
            driver.switchTo().frame(0);
            WebElement yesil = driver.findElement(By.cssSelector("div#green"));
            Actions actions = new Actions(driver);
            actions.clickAndHold(yesil).moveByOffset(-160, 0).release().perform();
            bekle(2);
            WebElement mavi = driver.findElement(By.cssSelector("div#blue"));
            actions.clickAndHold(mavi).moveByOffset(-160, 0).release().perform();


            //-Sarı olduğunu test edelim
            actions.clickAndHold(yesil).moveByOffset(160, 0).release().perform();
            WebElement kutu = driver.findElement(By.cssSelector("div#swatch"));
            String sari = kutu.getAttribute("style");
            String atributeName = "background-color: rgb(255, 255, 0);";
            Assert.assertEquals(sari, atributeName);
        }
    }
