package homeWork06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {

//    *** Aşağıdaki Task'i Junit framework'u ile yapınız
//- Before methodu ile drive'i olusturup ayarlamalari yapiniz
//- ebay sayfasına gidiniz
//- electronics bölümüne tıklayınız
//- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
//- Her sayfanın sayfa başlığını yazdıralım
//- After methodu ile sayfayı kapatalım

WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void ebay() {
        //- ebay sayfasına gidiniz
        driver.get("https://ebay.com");
        driver.findElement(By.xpath("(//li[@class='hl-cat-nav__js-tab'])[1]")).click();

        for (int i = 0; i <24 ; i++) {

            List<WebElement> liste = driver.findElements(By.xpath("//img[@width='225'and @height='225']"));
            liste.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
