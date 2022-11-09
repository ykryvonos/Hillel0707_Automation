package homeworks.homework29;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BasketPageLogic {
    public static String actualProductTitle;
    SelenideElement titleOfGoods = Selenide.$(By.xpath("//a[@data-testid='title']"));

    public BasketPageLogic productTitle(SelenideElement productTitle) {
        actualProductTitle = productTitle.getAttribute("innerText");
        return page(BasketPageLogic.class);
    }
}
