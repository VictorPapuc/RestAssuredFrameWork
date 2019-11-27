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

        Response response =
                given()
                        .when()
                        .get("/list");

        System.out.println(response.body().prettyPrint());

        //Validate Status code
        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void getOneStudent() {

        Response response =
                given()
                        .when()
                        .get("/1");

        System.out.println(response.body().prettyPrint());

//        Validate Status code
        given()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void getStudentwithQueryParameter() {

        Response response =
                given()
                        .when()
                        .get("/list?programme=Financial Analysis&limit=3");

//        System.out.println(response.body().prettyPrint());

        //Nu duplica cu pretyyPrint
        System.out.println(response.body().prettyPeek());

    }

    @Test
    public void getStudentwithParam() {

        Response response1 = given()
                .param("programme", "Financial Analysis")
                .param("limit", 2)
                .when()
                .get("/list");

        response1
                .then()
                .statusCode(200);

        System.out.println(response1.body().prettyPeek());

    }


}
