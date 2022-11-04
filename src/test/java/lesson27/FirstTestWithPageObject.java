package lesson27;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTestWithPageObject {
     WebDriver driver;
     WebDriverWait wait;

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
    public void testWithPageObject(){
        new MainPageLogic(driver, wait).typeTextToSearchInput("Mac").clickFindBtn();

        SearchPageLogic searchPageLogic = new SearchPageLogic(driver, wait);
        String tittleFromSearchPage = searchPageLogic.firstProductTittleText();
        searchPageLogic.clickOnFirstProduct();

        String tittleFromProductPage= new ProductPageLogic(driver, wait).getTittleText();

        Assert.assertEquals(tittleFromProductPage, tittleFromSearchPage);
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
