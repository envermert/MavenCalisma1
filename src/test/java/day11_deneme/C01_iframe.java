package day11_deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase;

public class C01_iframe extends TestBase {
    @Test
    public void iframe() {
        //➢ https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
        String iframeYazisi = driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(iframeYazisi);
        Assert.assertTrue(iframeYazisi.contains("black border"));

        //➢    Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
        String applicationsLists = driver.findElement(By.xpath("//h1")).getText();
        System.out.println("Applications lists:"+applicationsLists);
        Assert.assertEquals(applicationsLists,"Applications lists");


        //➢    Son olarak footer daki 'Povered By' yazisini varligini test edilip
        driver.switchTo().parentFrame();
        WebElement poweredBy = driver.findElement(By.xpath("(//p)[3]"));
        Assert.assertTrue(poweredBy.isDisplayed());



        //Son olarak sayfa başlığında iframe yazısının görünür olduğunu test edin
        WebElement sayfaBasligi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(sayfaBasligi.isDisplayed());
    }
}
