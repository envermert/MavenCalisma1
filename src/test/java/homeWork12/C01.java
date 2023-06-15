package homeWork12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities1.TestBase;

public class C01 extends TestBase {

    @Test
    public void test01() {

        //  ...Exercise2...
        //  1-driver olusturalim
        //  2-java class'imiza chromedriver.exe'yi tanitalim
        //  3-driver'in tum ekrani kaplamasini saglayalim
        //  4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
        //    söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
        //  5-"sahibinden.com" adresine gidelim
        driver.get("https://www.sahibinden.com");
        String sahibindenHandleDegeri = driver.getWindowHandle();
        //  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
       String baslik = driver.getTitle();
        String url = driver.getCurrentUrl();

        //  7-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(baslik.contains("oto"));
        Assert.assertFalse(url.contains("oto"));

        //  8-Ardindan "hepsiburada.com" adresine gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.hepsiburada.com");
        String hepsiburadaHandleDegeri = driver.getWindowHandle();

        //  9-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini
        //    kontrol edelim
          driver.getTitle().contains("Sitesi");

        //  10-Bi onceki web sayfamiza geri donelim
        driver.switchTo().parentFrame();
        //  11-sayfayi yenileyelim
        driver.navigate().refresh();
        //  12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.switchTo().window(hepsiburadaHandleDegeri);
        driver.close();
        //  13-En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
    }
}
