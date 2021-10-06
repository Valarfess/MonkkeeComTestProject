package api;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class ApiTest extends EndPoints {

    @Test(groups = "API")
    public void postTest() {
        User user = User.builder()
                .id(101)
                .age(26)
                .name("Pupkin")
                .title("test user")
                .build();

        UserResponse userResponse = given().
                baseUri(BASE_URI).
                when().
                body(user).
                post("/posts").
                then().
                log().all().extract().as(UserResponse.class);

        Assert.assertEquals(userResponse.getId(), user.getId(),"Ok");

    }

    @Test(groups = "API")
    public void getTest(){
        int id = 9;
        UserResponse userResponse = given().
                baseUri(BASE_URI).
                when().
                get(String.format("/posts/%d", id)).
                then().
                log().all().statusCode(200).extract().as(UserResponse.class);

        Assert.assertEquals(id,userResponse.getId());
    }

    @Test(groups = "API")
    public void putTest() {
        User user = User.builder()
                .id(1)
                .name("test-update")
                .salary(1234)
                .age(56)
                .build();

        UserResponse userResponse = given().
                baseUri(BASE_URI).
                when().
                body(user).
                put("/posts/1").
                then().
                log().all().extract().as(UserResponse.class);

        Assert.assertEquals(userResponse.getId(), user.getId(),"Ok");
    }

    @Test(groups = "API")
    public void deleteTest() {
        User user = User.builder()
                .name("test-update")
                .salary(1234)
                .title("test user")
                .build();

        UserResponse userResponse = given().
                baseUri(BASE_URI).
                when().
                body(user).
                delete("/posts/1").
                then().
                log().all().extract().as(UserResponse.class);

        Assert.assertNotSame(userResponse,user);
    }
}

