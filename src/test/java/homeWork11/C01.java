package homeWork11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities1.TestBase;

public class C01 extends TestBase {


    @Test
    public void test01() {

    //Yeni bir class olusturun: WindowHandle
    //Amazon anasayfa adresine gidin.
     driver.get("https://amazon.com");

     //Sayfa’nin window handle degerini String bir degiskene atayin
        String handle1 = driver.getWindowHandle();

    //Sayfa title’nin “Amazon” icerdigini test edin
        String baslik = driver.getTitle();
        Assert.assertTrue(baslik.contains("Amazon"));
        String amazonHandledegeri = driver.getWindowHandle();

    //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");

    //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String title = driver.getTitle();
        Assert.assertFalse(title.contains("TECHPROEDUCATION"));

    //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

    //Sayfa title’nin “Walmart” icerdigini test edin
        String walmartBaslik =driver.getTitle();
        Assert.assertTrue(walmartBaslik.contains("Walmart"));

    //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandledegeri);
        Assert.assertTrue(baslik.contains("Amazon"));
        
    }

}
