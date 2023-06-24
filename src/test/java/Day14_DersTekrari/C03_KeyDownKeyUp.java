package Day14_DersTekrari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu,Keys.SHIFT).//-->Arama kutusunda shift tusuna bastik
                sendKeys("selenium").//-->selenium metnini shift tusuna basili kaldigi icin buyuk yazdi
                keyUp(Keys.SHIFT). //Shift tusunu serbest biraktik
                sendKeys("-java",Keys.ENTER).//--> Bu kismi shift'i serbest biraktigimiz icin kucuk yazdi
                perform();
    }

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
        /*
        Mouse islemleri icin actions class'ini kullanmamiz gerekir. Fakat bir metin kutusundaki klavye islemleri icin 
        actions class'ina kullanmadan sendKeys() methodu ile de istedigimiz bir metni buyuk yazdirabilir,
        hatta birden fazla klavye tuslarina bastirabiliriz. Yukaridaki ornekte sendKeys() methodu ile Keys.SHIFT diyerek
        sonrasinda yazdirmak istedigimiz metni kucuk harfle yazmamiza ragmen buyuk harflerle yazdirdi, tekrar Keys.SHIFT
        kullanarak shift tusunu serbest birakmis olduk.
       
         */
    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium",Keys.ENTER);

        //Sayfayı bekleyin
        bekle(4);

        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).//Sayfa yenilendigi icin tekrar locate aldik
        sendKeys(Keys.COMMAND,"a");//-->Metni kesebilmemiz icin Command+a secmemiz gerekir.
        bekle(2);
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).
                sendKeys(Keys.COMMAND,"x"); //secilen metni Command+x ile kestik
        bekle(2);

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).
                sendKeys(Keys.COMMAND,"v",Keys.ENTER);//--> Kestigimiz metni Command +x ile tekrar arama kutusuna yapistirdik ve arattik
    }
}
