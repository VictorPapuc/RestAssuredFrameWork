package com.studentsapi.httpaction;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;


public class StudentGetTests {

    private static RequestSpecBuilder builder;
    private static RequestSpecification requestSpecification;

    private static ResponseSpecBuilder responseSpecBuilder;
    private static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";

        builder = new RequestSpecBuilder();
        requestSpecification = builder.build();

        responseSpecBuilder = new ResponseSpecBuilder();

        responseSpecBuilder.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
        responseSpecBuilder.expectStatusCode(200);
        responseSpecification = responseSpecBuilder.build();
    }

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
    public void getStudentWithParam() {

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


    @Test
    public void checkResponseTime() {

        //Validate Status code
        long time = given()
                .when()
                .get("/list")
                .timeIn(TimeUnit.NANOSECONDS);
//                .time();

        System.out.println(time);

        given()
                .spec(requestSpecification)
                .log()
                .all()
                .when()
                .get("/list")
                .then()
                .spec(responseSpecification);

    }


}
