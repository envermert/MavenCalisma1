package day15_deneme;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {

        String dosyaYolu ="/Users/enver/Desktop/Ekran Resmi 2023-06-19 20.54.52.png";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

    @Test
    public void test02() throws InterruptedException {
        String farkliYol ="";
        String isletimSistemiAdi = System.getProperty("os.name");
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));
        if (isletimSistemiAdi.contains("Mac")){
            farkliYol=System.getProperty("user.home");
        } else if (isletimSistemiAdi.contains("Win")) {
            farkliYol="C:/Users/Türkmen";
        }

        String ortakYol = "/Desktop/Ekran Resmi 2023-06-19 20.54.52.png";
        String dosyaYolu = farkliYol+ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        try {
            Files.delete(Paths.get(dosyaYolu));
        } catch (IOException e) {
            System.out.println("Dosya Bulunamadi");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));
        Thread.sleep(3000);

        try {
            Files.createFile(Paths.get(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

    @Test
    public void test03() {
        String dosyaYolu = "/Users/enver/Desktop/git1.txt";
        File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();
    }
}
