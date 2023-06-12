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

public class C03 {


    WebDriver driver;

    @Before
    public void before()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //●https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("http://zero.webappsecurity.com/");
    }

    @Test
    public void test01() {
    //2.Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        driver.navigate().back();
        driver.navigate().forward();

    //3.Login kutusuna “username” yazin
    //4.Password kutusuna “password.” yazin
    //5.Sign in tusuna basin(not: navigate.Back yapınız)
       driver.findElement(By.cssSelector("input[id='user_login']")).sendKeys("username", Keys.TAB,"password",Keys.TAB,Keys.TAB,Keys.ENTER);
       driver.navigate().back();

    //6.Pay Bills sayfasina gidin
    driver.findElement(By.cssSelector("li[id='onlineBankingMenu']")).click();
    driver.findElement(By.xpath("(//span[@class='headers'])[4]")).click();

    //7.“Purchase Foreign Currency” tusuna basin
    driver.findElement(By.xpath("(//li[@class='ui-state-default ui-corner-top'])[2]")).click();

   //8.“Currency” drop down menusunden Eurozone’u secin
        WebElement eurozone = driver.findElement(By.cssSelector("select[id='pc_currency']"));
        Select select = new Select(eurozone);
        select.selectByVisibleText("Eurozone (euro)");

    //9.“amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("1000");


        //10.“US Dollars” in secilmedigini test edin

        Assert.assertFalse(driver.findElement(By.cssSelector("#pc_inDollars_true")).isSelected());

        //11.“Selected currency” butonunu secin
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();

        //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.cssSelector("input[id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        WebElement kontrol = driver.findElement(By.cssSelector("div[id='alert_content']"));


    }













}



