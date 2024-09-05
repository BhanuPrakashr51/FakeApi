package org.Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FakeApi {

    @Test
    public static void allObject() {
        RestAssured.baseURI = "https://api.restful-api.dev/";
        Response res = given().
                when().get("objects").
                then().log().all().assertThat().statusCode(200).extract().response();
        System.out.println(res);


    }

    @Test
    public static void AllOjectResourceNotFound() {
        RestAssured.baseURI = "https://api.restful-api.dev/";
        Response res = (Response) given().
                when().get("objecthff").then().log().all().assertThat().statusCode(404).extract().response();
    }

    @Test
    public static void AllObjectMethodNotAllowed() {
        RestAssured.baseURI = "https://api.restful-api.dev/";
        Response res = given().
                when().put("Object").
                then().log().all().assertThat().statusCode(405).extract().response();
    }
}