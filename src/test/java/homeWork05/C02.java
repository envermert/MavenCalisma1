package homeWork05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    /*
-https://www.facebook.com adresine gidin
-Cookies’i kabul edin
-“Create an Account” button’una basin
-“radio buttons” elementlerini locate edin
-Secili degilse cinsiyet butonundan size uygun olani secin
 */
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void facebook() {
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        WebElement first=driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        WebElement second=driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        WebElement thirth=driver.findElement(By.xpath("(//*[@type='radio'])[3]"));
        if (!second.isSelected()){
            second.click();
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }



}