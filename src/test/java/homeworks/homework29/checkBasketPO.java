package homeworks.homework29;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class checkBasketPO {

    MainPageLogic mainPageLogic = new MainPageLogic();

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/");
    }

    @Test
    public void ProductInBasket() {
        mainPageLogic
                .clickOnCategory(mainPageLogic.compAndLaptopCategory)
                .clickOnCategory(new CategoryPageLogic().laptop)
                .addToBasket(new ProductPageLogic().firstProductBasket)
                .checkCountBasket("1")
                .firstProductTitle(new ProductPageLogic().firstProductTitle)
                .openBasket(new ProductPageLogic().basket)
                .productTitle(new BasketPageLogic().titleOfGoods);
        Assert.assertEquals(BasketPageLogic.actualProductTitle, ProductPageLogic.expectedProductTitle);
    }
}

//    Написать тест с использованием Selenide и PageObject
//    Открыть https://rozetka.com.ua/
//    Перейти в раздел «Компьютеры и ноутбуки»
//    Перейти в раздел « Ноутбуки»
//    Добавить первый товар в корзину
//    Проверить что в корзину добавился один товар
//    Перейти в корзину и проверить, что добавился правильный товар