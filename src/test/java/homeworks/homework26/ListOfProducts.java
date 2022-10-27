package homeworks.homework26;

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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListOfProducts {
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

        WebElement firstLinkList = driver
                .findElement(By.xpath("//ul[contains(@class,'menu-categories_')]/li[1]/a"));
        firstLinkList.click();

        WebElement notebook = driver
                .findElement(By.xpath("//ul[contains(@class,'grid_type_1_6')][1]//li[1]"));
        notebook.click();

        WebElement btnList = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'c94-1')]")));

        List<WebElement> listProductTitle = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));

        List<WebElement> listProductPrice = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));

        LinkedHashMap<String, String> listOfProducts = new LinkedHashMap<String, String>();

        for (int i = 0; i < 60; i++) {
            String title = listProductTitle.get(i).getAttribute("innerText").replace(" ", " ");
            String price = listProductPrice.get(i).getAttribute("innerText").replace(" ", " ");

            listOfProducts.put(title, price);
        }

        FileWriter fileWriter = new FileWriter("rozetkaTest");

        for (Map.Entry<String, String> entry : listOfProducts.entrySet()) {
            fileWriter.write(entry.getKey() + " - " + entry.getValue() + "\n");
        }
        fileWriter.close();
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
//    Перейти на https://rozetka.com.ua/
//        В сайд меню перейти в раздел Ноутбуки и компьютеры
//        Перейти в категорию Ноутбуки
//        На странице поисковой выдачи собрать все тайтлы(название товаров) и цены товаров. (60 штук)
//        Записать их в Map.
//        С помощью FileWriter записать данные с Map в файл rozetkaTest.txt (Пример ОЖ результат:
//        Ноутбук Acer Nitro 5 AN515-57-54K7 (NH.QESEU.003) Shale Black - 32 999)
