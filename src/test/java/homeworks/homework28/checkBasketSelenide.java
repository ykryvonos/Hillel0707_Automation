package homeworks.homework28;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class checkBasketSelenide {
    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/");
    }

    @Test
    public void ProductInBasket() {
        $(By.xpath("//ul[contains(@class,'menu-categories_')]/li[1]/a"))
                .click();
        $(By.xpath("//ul[contains(@class,'grid_type_1_6')][1]//li[1]"))
                .click();

        SelenideElement firstProduct = $(By.xpath("//li[contains(@class, 'catalog')][1]//span[@class='goods-tile__title']"));
        String firstProductTitle = firstProduct.getAttribute("innerText");

        $(By.xpath("//app-buy-button[1]"))
                .click();

        $(By.xpath("//span[contains(@class,'counter')]"))
                .shouldHave(text("1"));

        $(By.xpath("//li[contains(@class, 'cart')]"))
                .click();

        SelenideElement titleOfGoods = $(By.xpath("//a[@data-testid='title']"));
        String actualTitle = titleOfGoods.getAttribute("innerText");

        Assert.assertEquals(actualTitle, firstProductTitle);

    }
}
