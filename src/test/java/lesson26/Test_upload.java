package lesson26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_upload {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    @Test
    public void uploadTest() {
        WebElement uploadElement = driver.findElement(By.id("file-upload"));
        uploadElement.sendKeys("C:/Users/kryvonos.y/IdeaProjects/Hillel0707_Automation/test");

        WebElement uploadBtn = driver.findElement(By.id("file-submit"));
        uploadBtn.click();
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
