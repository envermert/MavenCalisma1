package homeWork09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02 {

    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //●https://amazon adresine gidin.
        driver.get("https://amazon.com");
    }

    @Test
    public void Test01() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        WebElement dropdown = driver.findElement(By.xpath("//select[@title='Search in']"));
        Select select = new Select(dropdown);
        Assert.assertTrue(select.getOptions().size()==45);
    }

    @Test
    public void test02() {
        //1.Kategori menusunden Books secenegi
        WebElement dropdown = driver.findElement(By.xpath("//select[@title='Search in']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Books");

        // 2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        //3.Bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String [] sonucYazisi = sonuc.getText().split(" ");
        String son = sonucYazisi[3];


        //Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonuc.getText().contains("Java"));


    }
}
