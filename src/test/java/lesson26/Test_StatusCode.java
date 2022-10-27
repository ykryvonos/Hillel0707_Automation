package lesson26;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class Test_StatusCode {

    @Test
    public void frameTest() throws  IOException {
        HttpURLConnection c = (HttpURLConnection)
                new URL("https://the-internet.herokuapp.com/status_codes/200").openConnection();

        c.connect();
        int statusCode = c.getResponseCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
    }
}
