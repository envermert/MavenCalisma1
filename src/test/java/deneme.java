import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities1.TestBase;

import java.time.Duration;

public class deneme extends TestBase {
    @Test
    public void test01() {

        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        WebElement buton= driver.findElement(By.xpath("(//button)[3]"));
        buton.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        //Actions actions = new Actions(driver);
        acceptAlert();

    }

    @Test
    public void test02() {

        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Change Text to Selenium Webdriver butonuna basın
        driver.findElement(By.xpath("(//button)[4]")).click();

        WebElement element=driver.findElement(By.xpath("//*[.='Selenium Webdriver']"));

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElement(element,"Selenium Webdriver"));

        //Selenium Webdriver yazisinin çıktığını test edin

        WebElement seleniumWebdriver = driver.findElement(By.xpath("//*[text()='Selenium Webdriver']"));
        Assert.assertEquals(seleniumWebdriver.getText(),"Selenium Webdriver");
        Assert.assertTrue(seleniumWebdriver.isDisplayed());

    }

    @Test
    public void test03() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Display button after 10 seconds butonuna tklayalım.
        driver.findElement(By.xpath("(//button)[5]")).click();

        //Çıkan yazının Enabled olduğunu test edin.
        WebElement button=driver.findElement(By.cssSelector("button[id='hidden']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(button));

        Assert.assertEquals(button.getText(),"Enabled");
    }

    @Test
    public void test04() {

        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Check Checkbox after 10 seconds butonuna basın.
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();

        //checkbox kutucuğunun tıklandığını test edin.
        WebElement checkbox=driver.findElement(By.xpath("//input[@id='ch']"));
        Wait<WebDriver> wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(200));
        wait.until(ExpectedConditions.elementToBeSelected(checkbox));

        Assert.assertTrue(checkbox.isSelected());


             /*
             elementToBeSelected() methodu bir checkbox kutucuğunun seçili olmasını bekler. Seçili ise tru verir.

             WebDriverWait wait = new WebDriverWait(driver, 10);
             WebElement checkbox = driver.findElement(By.id("checkboxId"));
             wait.until(ExpectedConditions.elementToBeSelected(checkbox));


             elementSelectionStateToBe() metodu, bir elementin seçili veya seçili olmayan durumunu doğrular.
             Bu metod, belirli bir elementin seçilme durumunu kontrol etmek için kullanılır.

             WebDriverWait wait = new WebDriverWait(driver, 10);
             WebElement checkbox = wait.until(ExpectedConditions.elementSelectionStateToBe(By.id("checkboxId"), true));
              */

    }
}


