package ScreenShot;

import com.google.common.io.Files;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities1.TestBase;

import java.io.File;
import java.io.IOException;

public class C01 extends TestBase {
    @Test
    public void screenShot() {
        driver.get("https://amazon.com");

        TakesScreenshot screenshot =(TakesScreenshot)driver;
        File image = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(image,new File("/Users/enver/Desktop/resimler/amazonwebpag.png"));
        } catch (IOException ioException) {
           ioException.printStackTrace();
        }
    }
}
