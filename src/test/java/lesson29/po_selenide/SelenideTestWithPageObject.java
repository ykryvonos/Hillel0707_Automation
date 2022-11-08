package lesson29.po_selenide;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SelenideTestWithPageObject {

    MainPageLogic mainPageLogic = new MainPageLogic();

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void firstTest() {
        mainPageLogic
                .checkCategoryQuantity(16)
                .clickOnCategory(mainPageLogic.compAndLaptopCategory)
                .clickOnCategory(new CategoryPageLogic().laptop)
                .checkProductQuantity(60);

    }
}
