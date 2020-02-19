package com.studentsapi.proxy;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProxyExample {

//    public static final ProxySpecification proxy = new ProxySpecification("localhost", 5555, "http");

    public static RequestSpecBuilder requestBuilder;
    public static RequestSpecification requestSpecification;


    @BeforeClass
    public static void init() {

//        ProxySpecification proxy = new ProxySpecification("localhost", 5555, "http");
        RestAssured.baseURI = "http://localhost/student";
//        RestAssured.proxy(proxy);

        requestBuilder = new RequestSpecBuilder();
        requestBuilder.setProxy("localhost", 5555, "http");
        requestSpecification = requestBuilder.build();

//        RestAssured.port = 8081;
    }

    @Test
    public void test() {

//        ProxySpecification proxy = new ProxySpecification("localhost", 5555, "http");

        RestAssured.
                given()
                .spec(requestSpecification)
//                .proxy("localhost", 5555)
//                .proxy(proxy)
                .when()
                .get("/list")
                .then()
                .log()
                .body();
    }

}
