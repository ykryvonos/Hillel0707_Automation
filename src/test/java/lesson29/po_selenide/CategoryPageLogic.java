package lesson29.po_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lesson27.SearchPageLogic_27;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CategoryPageLogic extends CategoryPageElements {

    public lesson29.po_selenide.SearchPageLogic clickOnCategory(SelenideElement category){
        category.shouldBe(Condition.visible);
        category.click();
        return  page(SearchPageLogic.class);
    }
}
