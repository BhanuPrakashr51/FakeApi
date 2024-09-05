package org.Api;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;

public class Reqres {

    @Test
    public static void createUser() {

        RestAssured.baseURI = "https://reqres.in/";

        JSONObject js =new JSONObject();
        js.put("name","morpheus");
        js.put("job","leader");

        given().body(js.toString()).
        when().post("api/users").
        then().log().all().
        assertThat().statusCode(201);

    }
    @Test

    public static void listUsers(){
        RestAssured.baseURI = "https://reqres.in/";

        given().queryParam("page",2).
                when().get("/api/users").
                then().log().all().
                assertThat().statusCode(200);
    }

    @Test
    public static void singleUser(){
          RestAssured.baseURI = "https://reqres.in/";

         given().pathParam("user",2)
                 .when().get("api/users/{user}")
                 .then().log().all().assertThat().statusCode(200);


    }

    @Test
    public static void single_user_3(){
        RestAssured.baseURI="https://reqres.in";
        given().pathParam("user",3)
                .when().get("/api/users/{user}")
                .then().assertThat().statusCode(200)
                .log().all();

    }






}
