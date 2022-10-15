package homeworks.homework24;

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


import static org.testng.Assert.assertTrue;

public class TopSale {
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
    public void checkTopSale() {
        WebElement firstLinkList = driver
                .findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']//li[1]"));
        firstLinkList.click();

        WebElement notebook = driver
                .findElement(By.xpath("//section[@class='content js_content']//rz-list-tile[1]"));
        notebook.click();

        WebElement filterRozetka = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-id='Rozetka']")));
        filterRozetka.click();

        WebElement filterMaxPrice = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='max']")));
        filterMaxPrice.click();
        filterMaxPrice.clear();
        filterMaxPrice.sendKeys("100000");

        WebElement filterOk = driver
                .findElement(By.xpath("//button[@class='button button_color_gray button_size_small slider-filter__button']"));
        filterOk.click();

        WebElement firstProduct = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//rz-grid[@class='ng-star-inserted']//span/..")));
        firstProduct.click();

        WebElement topSale = driver
                .findElement(By.xpath("//div[@class='main-slider__wrap ng-star-inserted']//span"));
        assertTrue(topSale.isDisplayed(),"Message top sale isn't displayed");
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
//    Перейти на https://rozetka.com.ua/
//        В сайд меню перейти в раздел Ноутбуки и компьютеры
//        Перейти в категорию Ноутбуки
//        Примерить фильтр "Продавец" Rozetka
//        Примерить фильтр "Цена" установть цену до - 100000
//        Перейти на продуктовую первого товара с плашкой " ТОП ПРОДАЖІВ"
//        Проверить что на продуктовой странице отображается плашка " ТОП ПРОДАЖІВ"