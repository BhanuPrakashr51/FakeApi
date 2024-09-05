package org.Api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonPlaceHolder {

    @Test
    public static void employees() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given().
        when().get("/posts").
        then().log().all().
        assertThat().statusCode(200);


    }

    @Test
    public static void postId_comments(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        given().pathParam("id",1).
        when().get("posts/{id}/comments")
                .then().log().all().assertThat().statusCode(200);

    }


}




