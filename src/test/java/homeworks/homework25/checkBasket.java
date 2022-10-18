package homeworks.homework25;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class checkBasket {
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
        WebElement firstLinkList = driver
                .findElement(By.xpath("//ul[contains(@class,'menu-categories_')]/li[1]/a"));
        firstLinkList.click();

        WebElement notebook = driver
                .findElement(By.xpath("//ul[contains(@class,'grid_type_1_6')][1]//li[1]"));
        notebook.click();

        WebElement firstProduct = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class, 'catalog')][1]//span[@class='goods-tile__title']")));
        String expectedTitle = firstProduct.getAttribute("innerText").trim();

        WebElement btnGoodsBasket = driver.findElement(By.xpath("//app-buy-button[1]"));
        btnGoodsBasket.click();

        WebElement countBasket = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'counter')]")));
        String countOfGoods = countBasket.getAttribute("innerText").trim();
        assertEquals(countOfGoods, "1");

        WebElement btnMainBasket = driver.findElement(By.xpath("//li[contains(@class, 'cart')]"));
        btnMainBasket.click();

        WebElement titleOfGoods = driver.findElement(By.xpath("//a[@data-testid='title']"));
        String actualTitle = titleOfGoods.getAttribute("innerText").trim();

        assertEquals(actualTitle, expectedTitle, "The title of goods is wrong");
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}

//    Открыть https://rozetka.com.ua/
//        Перейти в раздел «Компьютеры и ноутбуки»
//        Перейти в раздел « Ноутбуки»
//        Добавить первый товар в корзину
//        Проверить что в корзину добавился один товар
//        Перейти в корзину и проверить, что добавился правильный товар
