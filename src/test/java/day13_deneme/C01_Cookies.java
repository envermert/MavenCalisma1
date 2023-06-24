package day13_deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities1.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin
        Set<Cookie> cookies = driver.manage().getCookies();
        cookies.forEach(System.out::println);

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        Assert.assertTrue(cookies.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actual =driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expected = "USD";
        Assert.assertEquals(actual,expected);

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
       int eklenmedenOnce = driver.manage().getCookies().size();
        System.out.println(eklenmedenOnce);
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        int eklendiktenSonra = driver.manage().getCookies().size();
        System.out.println(eklendiktenSonra);
        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookies=driver.manage().getCookies();
        for (Cookie e:cookies) {
            System.out.println(e);
        }
        System.out.println("eklenmedenOnce = " + eklenmedenOnce);
        System.out.println("eklendiktenSonra = " + eklendiktenSonra);
        //7-ismi skin olan cookie’yi silin ve silindigini test edin

        Assert.assertEquals(1,eklendiktenSonra-eklenmedenOnce);

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();
        Assert.assertTrue(cookies.isEmpty());
        System.out.println(cookies.size());

    }
}
