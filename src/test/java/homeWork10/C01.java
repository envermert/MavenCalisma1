package homeWork10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {

    WebDriver driver;

    @Before
    public void before()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //●https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://www.google.com/");
    }

    @Test
    public void test01() {
        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Google"));

        // arama cubuguna "Nutella" yazıp aratın

        driver.findElement(By.cssSelector("textarea[id='APjFqb']")).sendKeys("Nutella", Keys.ENTER);

        // bulunan sonuc sayısını yazdırın
        String sonucYazisi = driver.findElement(By.cssSelector("div[id='result-stats']")).getText();
        String [] sonucSayisi = sonucYazisi.split(" ");
        String sonuc=sonucSayisi[1].replace(".","");
        System.out.println(sonuc);


        int intSonuc= Integer.valueOf(sonuc);
        System.out.println(sonuc);

        Assert.assertTrue(intSonuc>100000000);

        //if Ile cozumu;
//        if (intSonuc>100000000){
//            System.out.println("Passed");
//        }else System.out.println("Fail");

    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
