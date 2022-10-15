package lesson22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class RozetkaFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/");
    }

    final String EXPECTED = "Компьютер Apple Mac Studio M1 Ultra/48 ядер GPU/64GB/1TB";

    @Test
    public void rozetkaTest() throws InterruptedException {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Mac");

        WebElement btnsearch = driver.findElement(By.xpath("//button[contains(@class, 'button_color_green')]"));
        btnsearch.click();

        WebElement firstProduct = driver.findElement(By.xpath("//span[@class='goods-tile__title']"));
        String title = firstProduct.getText().trim();

 //       Assert.assertEquals(firstProduct, EXPECTED);
    }

    @AfterTest
    public void after(){
        driver.quit();
    }
}
