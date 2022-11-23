package lesson30;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class AshotExmpl {
    public WebDriver driver = new ChromeDriver();

    @Test
    public void ashot() throws IOException {
        driver.get("https://www.google.com.ua/");
        driver.manage().window().maximize();
        Screenshot screenshot =new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "PNG", new File("dirScreen/screen.png"));

    }

    @AfterTest
    public void after(){
        driver.close();
    }
}
