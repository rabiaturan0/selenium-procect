package day07_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesDownload extends TestBase {
    // Exercise 2...


    //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
    //2. LambdaTest.txt dosyasini indirelim
    //3. dosyanin bilgisayarınızda downloads'a basariyla indirilip indirilmedigini test ediniz

    @Test
    public void test02(){
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='LambdaTest.txt']")).click();
        //Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\rbtrn\\Downloads\\LambdaTest.txt")));  //Bu islemi dinamiklestirelim...
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\OneDrive\\Masaüstü\\text.txt";
        String dosyaYolu = farkliKisim + ortakKisim;


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
