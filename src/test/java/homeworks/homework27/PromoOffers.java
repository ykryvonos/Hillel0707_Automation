package homeworks.homework27;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PromoOffers {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void promotions() throws InterruptedException {
        loadPage();

        List<WebElement> promoOffers = driver.findElements(By.xpath("//h2[contains(text(), 'Акційні')]/..//li"));
        Assert.assertEquals(promoOffers.size(), 6);

        WebElement firstPromoPrice = driver.findElement(By.xpath("//h2[contains(text(), 'Акційні')]/..//span[@class='tile__price-value']"));
        String firstPrice = firstPromoPrice.getAttribute("innerText").trim() + "₴";

        WebElement firstTitle = driver.findElement(By.xpath("//section//a[@class='tile__picture']"));
        firstTitle.click();

        WebElement price = driver.findElement(By.xpath("//p[contains(@class,'red')]"));
        String actualPrice = price.getAttribute("innerText").trim();

        Assert.assertEquals(actualPrice, firstPrice, "The price does not match");

        mainPage();
        loadPage();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://rozetka.com.ua/ua/", "The URL does not match");

        scroll();
        List<WebElement> promotionOffersSecond = driver.findElements(By.xpath("//h2[contains(text(), 'Акційні')]/..//li"));
        Assert.assertEquals(promotionOffersSecond.size(), 6);
    }

    @AfterTest
    public void after() {
        driver.quit();
    }

    public void loadPage() {
        WebElement btnList = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'c94-1')]")));
    }

    public void scroll() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scroll(0, 1500)");
    }

    public void mainPage() {
        WebElement mainPage = driver.findElement(By.xpath("//a[@class='header__logo']"));
        mainPage.click();
    }
}

//        Открыть https://rozetka.com.ua/
//        Проверить, что в блоке Акционные предложения отображается 6 товаров
//        Сохранить цену первого товара
//        Перейти на продуктовую первого товара и проверить, что цена совпадает с сохраненной
//        Вернуться на главную страницу (проверка URL)
//        Проверить, что в блоке Акционные предложения отображается 6 товаров
