package lesson29.po_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CategoryPageLogic_cw extends CategoryPageElements {

    public SearchPageLogic_cw clickOnCategory(SelenideElement category){
        category.shouldBe(Condition.visible);
        category.click();
        return  Selenide.page(SearchPageLogic_cw.class);
    }
}
