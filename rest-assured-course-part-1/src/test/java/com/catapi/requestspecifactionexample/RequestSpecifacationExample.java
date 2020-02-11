package com.catapi.requestspecifactionexample;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RequestSpecifacationExample {


    static RequestSpecification requestSpecification;
    static RequestSpecBuilder builder;
    static String API_KEY = "";

    static ResponseSpecBuilder responseSpecBuilder;
    static ResponseSpecification responseSpecification;


    @BeforeClass
    public static void init() {

        RestAssured.basePath = "";
        RestAssured.baseURI = "";


        builder = new RequestSpecBuilder();
        builder.addQueryParam("query", "ipod");
        builder.addQueryParam("apiKey", API_KEY);
        builder.addQueryParam("format", "json");
        builder.addQueryParam("facet", "on");
        builder.addHeader("Accept", "*/*");

        requestSpecification = builder.build();

        responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectHeader("Content-Type", "applcation/json; cahrset=utf-8");
        responseSpecBuilder.expectHeader("Server", "Masher Proxy");
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectBody("query", equalTo("ipod"));
        responseSpecBuilder.expectBody("query", equalTo("Ipoh"));
        responseSpecBuilder.expectBody("query", equalTo("iposd"));
        responseSpecification = responseSpecBuilder.build();

    }

    @Test
    public static void test001() {
        given().spec(requestSpecification).when().get().then().spec(responseSpecification).log().all();
    }

    @Test
    public static void test002() {

    }


}
