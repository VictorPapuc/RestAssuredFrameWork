package com.students.tests;


import com.jayway.restassured.response.Response;
import com.student.base.TestBase;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;


public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInformation() {
        Response response = given().when().get("/list");
        System.out.println(response.body().prettyPrint());
        given().when().get("/list").then().statusCode(200);
    }

    @Test
    public void getStudentInfo() {
        Response response = given().when().get("/1");
        System.out.println(response.body().prettyPrint());
        given().when().get("/1").then().statusCode(200);

    }

    @Test
    public void getStudentsFromFA() {
        Response response = given().when().get("/list?programme=Financial Analysis&limit=2");

//        System.out.println(response.body().prettyPrint());
        System.out.println(response.body().prettyPeek());
        Response response1 = given().param("programme", "Financial Analysis").param("limit", 2).when().get("/list");
        System.out.println(response1.body().prettyPeek());


    }


}

