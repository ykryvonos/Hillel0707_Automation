package lesson28;


import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenidFirstTest {

    @BeforeMethod
    public void before(){
        Configuration.browserSize = "1920x1080";
//        Configuration.timeout = 6000; //default 4000ms
        open("https://rozetka.com.ua/");
    }

    @Test
    public void firstTest(){
        $(By.name("search"))
                .setValue("Mac");
         $(By.xpath("//button[contains(@class, 'button_color_green')]"))
                 .shouldBe(visible)
//                 .shouldHave(text("Знайти"). Duration.ofSeconds(5) )
                 .shouldNotHave(text("Alex"))
                         .click();
        sleep(5000);
    }
}
