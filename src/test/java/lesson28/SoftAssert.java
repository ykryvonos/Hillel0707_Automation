package lesson28;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftAssert {

    @Test(enabled = false)
    public void testCaseOne(){
        System.out.println("*** test case one started ***");
        Assert.assertEquals(5,5);
        System.out.println("hard assert success");
        Assert.assertTrue("Hello".equals("hello"));
        System.out.println("*** кпыре нрвено Test case execute ***");
    }

    @Test
    public void testCaseTwo(){
        org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
        System.out.println("*** test case one started ***");
        softAssert.assertEquals(5,5);
        System.out.println("hard assert success");
        softAssert.assertTrue("Hello".equals("hello"));
        System.out.println("***Test case execute ***");
        softAssert.assertAll();
    }
}
