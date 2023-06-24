package day17_deneme;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class C03_NullPointerExceptions {

    WebDriver driver;
    Faker faker;
    Actions actions;
    String name;
    int sayi;


    @Test
    public void test01() {
        driver.get("https://amazon.com");

    }

    @Test
    public void test02() {
        System.out.println(faker.name().firstName());//ay17_deneme.C03_NullPointerExceptions
    }

    @Test
    public void test03() {
        actions.sendKeys("enver").perform();//day17_deneme.C03_NullPointerExceptions
    }
}
