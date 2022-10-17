package lesson24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Test_FindElements {
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
    public void rozetkaTest() {
        WebElement firstLinkList = driver
                .findElement(By.xpath("//ul[contains(@class,'menu-categories_')]/li[1]/a"));
        firstLinkList.click();

        WebElement notebook = driver
                .findElement(By.xpath("//section[@class='content js_content']//rz-list-tile[1]"));
        notebook.click();

        List<WebElement> titleOfGoods = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
        int countOfGoods = titleOfGoods.size();
        assertEquals(countOfGoods, 60);

    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
