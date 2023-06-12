package AutomotionExcersize;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07 {
WebDriver driver;
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. 'Test Durumları' düğmesine tıklayın
    //5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        
    }

    @Test
    public void tarayici() {
        driver.get("https://automationexercise.com");
        System.out.println(driver.findElement(By.xpath("//div[@class='logo pull-left']")).isDisplayed());
        driver.findElement(By.cssSelector("button[type='button']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        System.out.println(driver.findElement(By.xpath("//h2//b")).isDisplayed());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
