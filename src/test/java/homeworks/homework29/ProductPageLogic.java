package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.security.PublicKey;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProductPageLogic {
    public static String expectedProductTitle;
    SelenideElement firstProductTitle = $(By.xpath("//li[contains(@class, 'catalog')][1]//span[@class='goods-tile__title']"));
    SelenideElement firstProductBasket = $(By.xpath("//app-buy-button[1]"));
    SelenideElement countBasket = $(By.xpath("//span[contains(@class,'counter')]"));
    SelenideElement basket = $(By.xpath("//li[contains(@class, 'cart')]"));


    public ProductPageLogic firstProductTitle(SelenideElement title) {
        expectedProductTitle = title.getAttribute("innerText");
        return page(ProductPageLogic.class);
    }

    public ProductPageLogic addToBasket(SelenideElement productBasket) {
        productBasket.shouldBe(Condition.visible);
        productBasket.click();
        return page(ProductPageLogic.class);
    }

    public ProductPageLogic checkCountBasket(String countBasket) {
        this.countBasket.shouldHave(Condition.text(countBasket));
        return this;
    }

    public BasketPageLogic openBasket(SelenideElement basket) {
        basket.shouldBe(Condition.visible);
        basket.click();
        return page(BasketPageLogic.class);
    }
}
