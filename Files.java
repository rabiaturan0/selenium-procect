package day07_practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

public class Files {
    // Exercise 1...

// masaustunde bir text dosyası olusturun
// masaustundeki text dosyasının varlıgını test edin
    @Test
    public void test01(){
        //"C:\Users\rbtrn               \OneDrive\Masaüstü\text.txt"

        Assert.assertTrue(java.nio.file.Files.exists(Paths.get("C:\\Users\\rbtrn\\OneDrive\\Masaüstü\\text.txt")));

        String farkliKisim =System.getProperty("user.home");
        System.out.println(farkliKisim);
        String ortakKisim = "\\OneDrive\\Masaüstü\\text.txt";
        String dosyaYolu = farkliKisim + ortakKisim;
        Assert.assertTrue(java.nio.file.Files.exists(Paths.get(dosyaYolu)));
    }
}
