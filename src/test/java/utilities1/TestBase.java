package utilities1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {

   protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
       // driver.quit();
    }

    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //AcceptAlert

    public void acceptAlert(){
        driver.switchTo().alert().accept();

    }

    //DismissAlert
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();

    }

    //getTextAlert
    public String getTextAlert(){
       return driver.switchTo().alert().getText();

    }
    //sendKeysAlert
    public void sendKeysAlert(String text){
        driver.switchTo().alert().sendKeys(text);

    }
    //DropDown VisibleText
    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);


    }
    //DropDown Index
    public void selectIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);

    }
    //DropDown Value
    public void selectValue(WebElement ddm, String value){
    Select select = new Select(ddm);
    select.selectByValue(value);

    }

    //SwitchTo

    public void switchTo(int index){
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(index));
    }

    //SwitchToWindow
    public void switchToWindow2(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }


}
