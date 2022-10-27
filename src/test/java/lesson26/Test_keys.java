package lesson26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_keys {
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

    @Test
    public void uploadTest() {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(Keys.chord(Keys.SHIFT,"mac"));

        WebElement btnsearch = driver.findElement(By.xpath("//button[contains(@class, 'button_color_green')]"));
        btnsearch.sendKeys(Keys.ENTER);
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
