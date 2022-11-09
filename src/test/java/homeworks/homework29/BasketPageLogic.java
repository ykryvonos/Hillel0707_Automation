package homeworks.homework29;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasketPageLogic {
    SelenideElement titleOfGoods = Selenide.$(By.xpath("//a[@data-testid='title']"));

    public String productTitle(SelenideElement productTitle) {
         String actualResult = productTitle.getAttribute("innerText");
        return actualResult;
    }
}
