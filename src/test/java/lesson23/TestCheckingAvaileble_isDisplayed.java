package lesson23;

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

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class TestCheckingAvaileble_isDisplayed {
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
        public void rozetkaTest() throws IOException {
            WebElement searchInput = driver.findElement(By.name("search"));
            searchInput.sendKeys("Mac");

            WebElement btnSearch = driver.findElement(By.xpath("//button[contains(@class, 'button_color_green')]"));
            btnSearch.click();

            WebElement firstProduct = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='goods-tile__title']")));
            firstProduct.click();
            WebElement productPageTitle = driver.findElement(By.xpath("//h1[@class='product__title']"));
            WebElement productPrice = driver.findElement(By.xpath("//p[@class='product-prices__big']"));

            String productPageTittleText = productPageTitle.getAttribute("innerText").trim();
            String productPriceText = productPrice.getText();

            WebElement availabilityOfProduct = driver.findElement(By.cssSelector("p.status-label--green"));
            String availabilityOfProductColor = availabilityOfProduct.getCssValue("color");

            if (availabilityOfProduct.isDisplayed() && availabilityOfProductColor.equals("rgba(0, 160, 70, 1)")){
                FileWriter fileWriter = new FileWriter("test");
                fileWriter.write(productPageTittleText + " " + productPriceText);
                fileWriter.close();
            }

        }

        @AfterTest
        public void after() {
            driver.quit();
        }
    }

