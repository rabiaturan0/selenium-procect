package grup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestCase {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https:/automationexercise.com");
    }

    @Test
    public void selectFromDropdown() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());


        //4. Click on 'Products' button   //reklami gectik//
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String expectedTitle = "ALL PRODUCTS";
        String actualTitle = driver.getTitle().toUpperCase();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //6. Enter product name in search input and click search button
        WebElement webElement = driver.findElement(By.xpath("//input[@id='search_product']"));
        webElement.sendKeys("Tshirt");
        driver.findElement(By.xpath("//*[@class='fa fa-search']")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed());

        //8. Verify all the products related to search are visible
        List<WebElement> list = driver.findElements(By.tagName("img"));
        List<WebElement> tsirt = new ArrayList<>();

        for (int i = 2; i < list.size() - 1; i++) {
            tsirt.add(list.get(i));
        }
        for (WebElement w : tsirt) {
            Assert.assertTrue(w.isDisplayed());
        }
    }
}


