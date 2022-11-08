package lesson29.po_selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import javax.lang.model.element.Element;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPageElement {
    ElementsCollection categorySideBarMenu = $$(By.xpath("//a[@class='menu-categories__link']"));

    SelenideElement compAndLaptopCategory = $(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]/a"));

}
