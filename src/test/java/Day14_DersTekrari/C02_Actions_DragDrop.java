package Day14_DersTekrari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        /*
        drag ve drop wbelemenleri iframe icinde oldugu icin iframe gecis yapmaliyiz.
         */
        driver.switchTo().frame(0);

        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        /*
            Eger bir haraketli webelementi tutup baska bir webelementin uzerine birakmak istersek
        suruklemek istedigimiz webelementin locate'ini alip uzerine birakacagimiz webelementin locate'ini de alarak
        dragAndDrop(kaynak,hedef) methodu ile islemi gerceklestirebiliriz.
         */

    }

    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        /*
        drag ve drop wbelemenleri iframe icinde oldugu icin iframe gecis yapmaliyiz.
         */
        driver.switchTo().frame(0);

        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//--> Bu method ile webelemente mosue ile basili tuttuk
            moveToElement(drop).//--> Bu method ile basili tuttugumuz webelementi diger webelementin uzerine goturduk
            release().//--> Bu method ile basili tuttugumuz webelementi serbest biraktik
            perform();//--> islemi sonlandirdik.

    }

    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        /*
        drag ve drop wbelemenleri iframe icinde oldugu icin iframe gecis yapmaliyiz.
         */
        driver.switchTo().frame(0);

        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(160,45). //-->Belirtmis oldugumuz koordinatlara webelementine tasir.
                release().perform();

    }
}
