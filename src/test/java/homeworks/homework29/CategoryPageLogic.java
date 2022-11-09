package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CategoryPageLogic {

    SelenideElement laptop = $(By.xpath("//ul[contains(@class,'grid_type_1_6')][1]//li[1]"));

    public ProductPageLogic clickOnCategory(SelenideElement category){
        category.shouldBe(Condition.visible);
        category.click();
        return  Selenide.page(ProductPageLogic.class);
    }
}
