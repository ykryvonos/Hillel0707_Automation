package lesson29;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SelenideMethodExmpl {
    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void ProductInBasket() {
        String currentUrl = url();
        System.out.println(currentUrl);

        String source = source();
        System.out.println(source);
    }
}
