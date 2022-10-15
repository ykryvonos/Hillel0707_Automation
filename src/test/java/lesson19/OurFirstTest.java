package lesson19;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OurFirstTest {

    @Parameters({"username", "password"})

    @Test(groups = {"regression"})
    public void firstTestMethod(String user, String pass) {
        System.out.println("it is first test method");
    }

    @Test
    public void secondTestMethod(){
        System.out.println("it is second test method");
    }
}
