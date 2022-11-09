package homeworks.homework29;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lesson29.po_selenide.CategoryPageLogic_cw;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPageLogic {
    ElementsCollection categorySideBarMenu = $$(By.xpath("//a[@class='menu-categories__link']"));
    SelenideElement compAndLaptopCategory = $(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]/a"));


    public MainPageLogic checkCategoryQuantity(int size){
        categorySideBarMenu.shouldHave(CollectionCondition.size(size));
        return this;
    }

    public CategoryPageLogic clickOnCategory(SelenideElement category){
        category.shouldBe(Condition.visible);
        category.click();
        return  page(CategoryPageLogic.class);
    }
}

