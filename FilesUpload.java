package day07_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class FilesUpload extends TestBase {
    // Exercise 3...

    // masaustunde bir deneme dosyası olusturun
    // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
    // 'Upload' butonuna basın
    // 'File Uploaded!' yazısının goruntulendigini test edin


    @Test
    public void test03() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaSecYolu = driver.findElement(By.xpath("//input[@id='file-upload']"));
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\OneDrive\\Masaüstü\\text.txt";
        String yuklenecekDosya = farkliKisim + ortakKisim;
        dosyaSecYolu.sendKeys(yuklenecekDosya);
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        WebElement fileUploadedYazisi = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploadedYazisi.isDisplayed());

    }
}
