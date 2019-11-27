package com.students.tests;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;


public class StudentGetTests {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
    }

    @Test
    public void getAllStudentsInformation() {
        Response response = given().when().get("/list");
        System.out.println(response.body().prettyPrint());

    }


}
