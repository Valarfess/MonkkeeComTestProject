package model.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class ApiTest extends EndPoints {

    @Test
    public void getTest() {
        given().
                baseUri(BASE_URI).
                when().
                get("/posts").
                then().
                log().all().assertThat().statusCode(200);
    }

    @Test
    public void postTest() {
        User user = User.builder()
                .name("test")
                .salary(123)
                .age(23)
                .build();

        given().
                baseUri(BASE_URI).
                when().
                body(user).
                post("/posts").
                then().
                log().all().assertThat().statusCode(201);
    }

    @Test
    public void putTest() {
        User user = User.builder()
                .name("test-update")
                .salary(1234)
                .build();

        given().
                baseUri(BASE_URI).
                when().
                body(user).
                put("/posts/1").
                then().
                log().all().assertThat().statusCode(200);
    }

    @Test
    public void deleteTest() {

        given().
                baseUri(BASE_URI).
                when().
                delete("/posts/1").
                then().
                log().all().assertThat().statusCode(200);
    }

}

