package lesson25;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class Test_Handles {
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
    public void checkBasket() {
        WebElement login = driver.findElement(By.xpath("//li[contains(@class, '--user')]"));
        login.click();

        WebElement reg = driver.findElement(By.xpath("//button[contains(@class, 'register-link')]"));
        reg.click();

        WebElement privatePolicy = driver.findElement(By.xpath("//a[contains(@class, 'button--link')]"));

        String mainTab = driver.getWindowHandle();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        driver.switchTo().window(mainTab);

//        если вкладок больше двух:
//        Set<String> myTabCollection = driver.getWindowHandles();
//        ArrayList<String> tabs2 = new ArrayList<String>(myTabCollection);
//        int lastTab = tabs2.size() - 1;
//        driver.switchTo().window(tabs2.get(lastTab));
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
