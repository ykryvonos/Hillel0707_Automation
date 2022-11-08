package lesson27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageLogic {
    By searchInput = By.name("search");
    By findBtn = By.xpath("//button[contains(@class, 'button_color_green')]");

    private  final WebDriver driver;

    private WebDriverWait wait;

    public MainPageLogic(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
@FindBy(xpath = "")
    private WebElement loginBtn;

    public MainPageLogic loginBtnClick(){
        loginBtn.click();
        return this;
    }
    public MainPageLogic typeTextToSearchInput (String text){
        driver.findElement(searchInput).sendKeys(text);
        return this;
    }

    public SearchPageLogic_27 clickFindBtn(){
        driver.findElement(findBtn).click();
        return  new SearchPageLogic_27(driver, wait);
    }
}
