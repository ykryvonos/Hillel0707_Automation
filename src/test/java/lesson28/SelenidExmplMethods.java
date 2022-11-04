package lesson28;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenidExmplMethods {
    @BeforeMethod
    public void before(){
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/");
    }
    @Test
    public void firstTest(){
        SelenideElement findBtn = $(By.xpath("//button[contains(@class, 'button_color_green')]"));
        String textFromFindBtn = findBtn.text();
        System.out.println(textFromFindBtn);

        String formActionAttrFromFindBtn = findBtn.attr("fromAction");
        System.out.println(formActionAttrFromFindBtn);

        String backGroundFromFindBtn = findBtn.getCssValue("background-color");
        System.out.println(backGroundFromFindBtn);
    }

}
