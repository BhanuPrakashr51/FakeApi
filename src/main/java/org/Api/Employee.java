package org.Api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Employee {

    public static int employeeId(int employee_Id){

        return employee_Id;
    }


    /*
    this endpoint will fetch the employee details
     */

    @Test
    public static int employees() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/";

       Response res= given().
        when().get("api/v1/employees").
        then().log().all().
        assertThat().statusCode(200).extract().response();
        JsonPath jsonPath = new JsonPath(res.asString());
      return (jsonPath.getInt("data[0].id"));
//        System.out.println("first employee ID is " + employeeId);


    }
    @Test
    public static void employees_ResourceNotFound(){
        RestAssured.baseURI = "https://dummy.restapiexample.com/";

                given().
                when().get("api/v1/employeestyry").
                then().log().all().
                assertThat().statusCode(404).extract().response();

    }
    @Test
    public static void employees_Methodnotallowed(){
        RestAssured.baseURI = "https://dummy.restapiexample.com/";
                given().
                 when().patch("api/v1/employees").
                        then().log().all().assertThat().statusCode(405);

    }

    @Test
    public static void employee_employeeId() {
       RestAssured.baseURI = "https://dummy.restapiexample.com/";
      // int employee_Id=1;
        given().pathParam("employee_Id",employeeId(5)).
        when().get("api/v1/employee/{employee_Id}").
        then().log().all().assertThat().statusCode(200);

    }
    @Test
    public static void employees_EmployeeIdMethodNotAllowed(){
        RestAssured.baseURI = "https://dummy.restapiexample.com/";
                given().pathParam("employee_Id",employeeId(5)).
                when().patch("api/v1/employee/{employee_Id}").
                then().log().all().assertThat().statusCode(405);


    }
    @Test
    public static void employees_EmployeeIdResourcNotFound(){
        RestAssured.baseURI = "https://dummy.restapiexample.com/";
        given().pathParam("employee_Id",5).
        when().get("api/v1/employee123/{employee_Id}").
                then().log().all().assertThat().statusCode(404);


    }
@Test
    public static void create_newEmployee(){
    RestAssured.baseURI = "https://dummy.restapiexample.com";
     given().
     when().get("/api/v1/create").
       then().log().all().assertThat().statusCode(200);

    }
    @Test
       public static void create_newEmployeeResourceNotFound(){
        RestAssured.baseURI = "https://dummy.restapiexample.com";
                given().
                when().get("/api/v1/creategh").
                then().log().all().assertThat().statusCode(404);


    }
    @Test
    public static void create_newEmployeeMethodNotAllowed(){
        RestAssured.baseURI = "https://dummy.restapiexample.com";
                given().
                when().put("/api/v1/create").
                        then().log().all().assertThat().statusCode(405);

    }

    @Test
     public static void update_employeeId(){
        RestAssured.baseURI ="https://dummy.restapiexample.com";
        given().pathParam("employee_id",21).
        when().put("/api/v1/update/{employee_id}").
        then().log().all().assertThat().statusCode(200);

    }
    @Test
    public static void update_employeeIdResourceNotFound(){
        RestAssured.baseURI ="https://dummy.restapiexample.com";
        given().pathParam("employee_id",21).
                when().put("/api/v1/updateytrggf/{employee_id}").
                then().log().all().assertThat().statusCode(404);
    }@Test
      public static void delete_employeeId() {
        RestAssured.baseURI = "https://dummy.restapiexample.com";
        given().pathParam("employee_Id", 1).
                when().delete("/api/v1/delete/{employee_Id}").
                then().log().all().assertThat().statusCode(200);


    }
    @Test
    public static void payLodBuilding(){
        JSONObject lotto =new JSONObject();
        lotto.put("lottoId",5);
        List<Integer> winningNumber=new ArrayList<>();
        winningNumber.add(2);
        winningNumber.add(45);
        winningNumber.add(34);
        winningNumber.add(23);
        winningNumber.add(7);
        winningNumber.add(5);
        winningNumber.add(3);
        lotto.put("winning-numbers",winningNumber);
        JSONObject winner_0 =new JSONObject();
        winner_0.put("winnerId",23);
        List<Integer> winners_Numbers_0=new ArrayList<>();
        winners_Numbers_0.add(2);
        winners_Numbers_0.add(45);
        winners_Numbers_0.add(34);
        winners_Numbers_0.add(23);
        winners_Numbers_0.add(3);
        winners_Numbers_0.add(5);
        winner_0.put("numbers",winners_Numbers_0);
        JSONObject winner_1 =new JSONObject();
        winner_1.put("winnerId",54);
        List<Integer> winners_Numbers_1=new ArrayList<>();
        winners_Numbers_1.add(52);
        winners_Numbers_1.add(3);
        winners_Numbers_1.add(12);
        winners_Numbers_1.add(11);
        winners_Numbers_1.add(18);
        winners_Numbers_1.add(22);
        winner_1.put("numbers",winners_Numbers_1);
     JSONArray jsonArray=new JSONArray();
        jsonArray.put(winner_0);
        jsonArray.put(winner_1);
        lotto.put("winners",jsonArray);
        JSONObject js =new JSONObject();
        js.put("lotto",lotto);
        System.out.println(js);
    }
    @Test
    public static void storePayLoadBuilding() {
        JSONObject js = new JSONObject();
        JSONObject js0 = new JSONObject();
        js0.put("author", "Nigel Rees");
        js0.put("category", "reference");
        js0.put("price", 8.95);
        js0.put("title", "Sayings of the Century");
        JSONObject js1 = new JSONObject();
        js1.put("author", "Evelyn Waugh");
        js1.put("category", "fiction");
        js1.put("price", 12.99);
        js1.put("title", "Sword of Honour");
        JSONObject js2 = new JSONObject();
        js2.put("author", "Herman Melville");
        js2.put("category", "fiction");
        js2.put("isbn", "0-5.5.01311-3");
        js2.put("price", 8.99);
        js2.put("title", "Moby Dick");
        JSONObject js3 = new JSONObject();
        js3.put("author", "J. R. R. Tolkien");
        js3.put("category", "fiction");
        js3.put("isbn", "0-395-19395-8");
        js3.put("price", 22.99);
        js3.put("title", "The Lord of the Rings");
        JSONArray book = new JSONArray();
        book.put(js0);
        book.put(js1);
        book.put(js2);
        book.put(js3);
        JSONObject book_1 = new JSONObject();
        book_1.put("book", book);
        js.put("store", book_1);
        System.out.println(js);
    }
}