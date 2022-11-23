package lesson31;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class TestAvatarAndIdWithPojo {
    private final static String URL  = "https://reqres.in/";

    @Test
    public void checkAvatarAndId(){

        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data",UserData.class);

        users.stream().forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));

        Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("reqres.in")));
    }
}
