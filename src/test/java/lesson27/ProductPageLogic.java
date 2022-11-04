package lesson27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPageLogic {
    By productTittle = By.xpath("//h1[@class='product__title']");

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPageLogic(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public String getTittleText(){
        return driver.findElement(productTittle).getText();
    }
}
