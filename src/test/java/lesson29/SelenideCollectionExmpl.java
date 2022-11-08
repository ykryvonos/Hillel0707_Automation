package lesson29;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideCollectionExmpl {
    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void ProductInBasket() {
        ElementsCollection sideBarMenu = $$(By.xpath("//a[@class='menu-categories__link']"));
        int  sizeCollection = sideBarMenu.size();

        System.out.println(sizeCollection);

        String text = sideBarMenu.get(1).getText();
        System.out.println(text);

        ElementsCollection sideBarMenuFilter = sideBarMenu.filterBy(Condition.text("Смартфони, ТВ і електроніка"));
        System.out.println(sideBarMenuFilter.size() + " - sideBarMenuFilter size");

        sideBarMenu.shouldHave(CollectionCondition.size(16));
    }
}
