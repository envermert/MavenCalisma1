package homeWork07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {


    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Before
    public void setUp() throws Exception {
        //Before methodunda http://www.google.com adresine gidin
        driver.get("http://www.google.com");
    }

    @Test
    public void godFather() {
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("The God Father", Keys.ENTER);
        WebElement sonuc =  driver.findElement(By.cssSelector("div#result-stats"));

        String[] sonucYazisi = sonuc.getText().split(" ");
        System.out.println(sonucYazisi[1]);
    }

    @Test
    public void LordOfTheRings() {
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Lord of the Rings", Keys.ENTER);
        WebElement sonuc =  driver.findElement(By.cssSelector("div#result-stats"));
        String[] sonucYazisi = sonuc.getText().split(" ");
        System.out.println(sonucYazisi[1]);
    }

    @Test
    public void KillBill() {
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Kill Bill", Keys.ENTER);
        WebElement sonuc =  driver.findElement(By.cssSelector("div#result-stats"));
        String[] sonucYazisi = sonuc.getText().split(" ");
        System.out.println(sonucYazisi[1]);
    }


    //After method'u ile başlıkları yazdırınız
    @After
    public void tearDown() throws Exception {
        System.out.println(driver.getTitle());

    }
    //AfterClass ile browser'ı kapatınız
    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
