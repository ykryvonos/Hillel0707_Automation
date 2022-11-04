package lesson27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageLogic {
    By firstProductTittle = By.xpath("//span[@class='goods-tile__title']");

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPageLogic(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public String firstProductTittleText(){
        return driver.findElement(firstProductTittle).getText();
    }

    public ProductPageLogic clickOnFirstProduct(){
        driver.findElement(firstProductTittle).click();
        return new ProductPageLogic(driver, wait);
    }
}
