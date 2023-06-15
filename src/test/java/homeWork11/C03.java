package homeWork11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities1.TestBase;

import java.security.Key;

public class C03 extends TestBase {
    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("(//a[@class='mdl-tabs__tab'])[1]")).click();
        // İkinci emoji öğelerini yazdırınız
        System.out.println(driver.findElement(By.xpath("//div[@id='nature']")).getText());
        // Parent iframe e geri donun
        driver.switchTo().parentFrame();
        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.xpath("//input[@class='mdl-textfield__input']")).sendKeys("enver", Keys.TAB,"asdad",Keys.TAB,"asdasd",Keys.TAB,"sdas",Keys.TAB,"asd",Keys.TAB,"dasda",Keys.TAB,"as",Keys.TAB,"wer", Keys.TAB,"ad",Keys.TAB,"as",Keys.TAB,"asda",Keys.TAB,Keys.ENTER);
        // Apply button a basiniz

    }


}
