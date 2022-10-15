package lesson19;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;

public class firstTestRun {

    private WebDriver driver;

    @BeforeTest
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void firstRun() {
        driver.get("https://www.google.com.ua/");
    }

    WebElement logo = driver.findElement(By.xpath("//img[@alt='Rozetka Logo']"));
    WebElement logoCss = driver.findElement(By.cssSelector("img[alt='Rozetka Logo']"));
    WebElement search = driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"));
    WebElement searchCss = driver.findElement(By.cssSelector("button[class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"));
    WebElement autofication = driver.findElement(By.xpath("//li[@class='header-actions__item header-actions__item--user']"));
    WebElement autoficationCss = driver.findElement(By.cssSelector("li[class='header-actions__item header-actions__item--user']"));
}
