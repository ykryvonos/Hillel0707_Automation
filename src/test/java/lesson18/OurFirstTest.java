package lesson18;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OurFirstTest {

    @BeforeTest
    public void beforeTest(){
        System.out.println("executed method before test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("executed method before method");
    }

    @Test(description = "about test")
    public void firstTest(){
        System.out.println("open google.com.ua");
    }

    @Test
    public void secondTest(){
        System.out.println("open apple.com");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("executed method after test");
    }
}

