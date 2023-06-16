package day12_deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities1.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandles extends TestBase {
    @Test
    public void test01() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkHandle = driver.getWindowHandle();

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String title = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, title);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        bekle(3);

        Set<String> pencereler = driver.getWindowHandles();
        for (String w : pencereler) {
            if (!w.equals(ilkHandle)) {
                driver.switchTo().window(w);
            }

        }


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String ikinciSayfatitle = driver.getTitle();
        String ikinciExpectedTitle = "New Window";
        Assert.assertEquals(ikinciExpectedTitle, ikinciSayfatitle);

        String ikinciSayfaHandleDegeri = driver.getWindowHandle();

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkHandle);

        String title1 = driver.getTitle();
        String expectedTitle1 = "The Internet";
        Assert.assertEquals(expectedTitle1, title1);


        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandleDegeri);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkHandle);

    }

    @Test
    public void test02() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkHandle = driver.getWindowHandle();

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String title = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, title);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        bekle(3);

        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        Assert.assertEquals(driver.getTitle(), "New Window");


        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.

        driver.switchTo().window(handles.get(0));
        String title2 = driver.getTitle();
        String expectedTitle2 = "The Internet";
        Assert.assertEquals(expectedTitle2, title2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(handles.get(1));

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(handles.get(0));

    }

    @Test
    public void test03() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkHandle = driver.getWindowHandle();

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String title = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, title);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String ilkTitle = driver.getTitle();
        String ilkExpectedTitle = "The Internet";
        Assert.assertEquals(ilkExpectedTitle, ilkTitle);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

    }

    @Test
    public void test04() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //"Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //ikinci sayfa Title'ının "New Window" olduğunu test edin.
        switchTo(1);
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);

        //ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        switchTo(0);
        String ilkactualTitle = driver.getTitle();
        String ilkexpectedTitle = "The Internet";
        Assert.assertEquals(ilkexpectedTitle, ilkactualTitle);

        //  ikinci sayfaya tekrar geçin.
        switchTo(1);
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        switchTo(0);
        bekle(2);

    }
}