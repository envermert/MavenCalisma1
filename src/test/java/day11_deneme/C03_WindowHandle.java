package day11_deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities1.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void test01() {

        // Window 1'de(yeni bir pencerede)  https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedWindowHandle= driver.getWindowHandle();


        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle= "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);
        String techproedHandleDegeri=driver.getWindowHandle();

        //Window 2'de(yeni bir pencerede)  https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youtubeHandleDegeri = driver.getWindowHandle();

        //Window 3'te(yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinHandleDegeri = driver.getWindowHandle();
        bekle(3);
        // WindowType.TAB -->Yeni bir sekme acar.

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproedWindowHandle);
        bekle(3);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeHandleDegeri);
        bekle(3);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandleDegeri);
        bekle(3);

    }
}
