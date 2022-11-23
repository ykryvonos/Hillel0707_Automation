package lesson30;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AshotRegression {
    public WebDriver driver = new ChromeDriver();

    @Test
    public void ashot() throws IOException {
        driver.get("https://www.google.com.ua/");
        driver.manage().window().maximize();
        Screenshot screenshot =new AShot().takeScreenshot(driver);

        BufferedImage expectedImg =ImageIO.read(new File(""));
        BufferedImage actualImg = screenshot.getImage();

        ImageDiffer imageDiffer = new ImageDiffer();
        ImageDiff imageDiff = imageDiffer.makeDiff(expectedImg, actualImg);

        Assert.assertTrue(imageDiff.hasDiff(), "ok");

//        if(imageDiff.hasDiff()){
//            System.out.println("ok");
//        }else {
//            System.out.println("error");
//        }
    }

    @AfterTest
    public void after(){
        driver.close();
    }
}
