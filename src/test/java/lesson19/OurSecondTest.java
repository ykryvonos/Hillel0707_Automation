package lesson19;

import org.testng.annotations.Test;

public class OurSecondTest {

    @Test(groups = {"regression"})
    public void thirdTestMethod(){
        System.out.println("it is third test method");
    }
}
