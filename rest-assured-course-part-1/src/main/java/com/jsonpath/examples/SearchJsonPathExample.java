package com.jsonpath.examples;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class SearchJsonPathExample {

    static final String APIKEY = "f0010f87-9860-4c13-949f-27afd7299098";



    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "https://api.thecatapi.com/";
        RestAssured.basePath = "/v1";

    }

    @Test
    public void test001() {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids = given()
                .headers("x-api-key", APIKEY)
                .when()
                .get("/votes")
                .then()
                .extract()
                .path("id");

        for (int id : ids
        ) {
            System.out.println(id);
        }

        int actual = 123856;

        ArrayList<Integer> idss = new ArrayList<>();
        idss.add(123856);
        Assert.assertEquals("Integer is equal to ", ids, idss);
    }

    @Test
    public void test002() {

        given()
                .headers("x-api-key", APIKEY)
                .when()
                .get("/votes");
    }

    @Test
    public void test003() {

        RequestSpecification httpRequest = RestAssured
                .given()
                .headers("x-api-key", APIKEY);

        Response response = httpRequest.get("/votes");
        JsonPath jsonPathEvaluator = response.jsonPath();
        String value  = jsonPathEvaluator.getString("id");

        System.out.println(value);

    }
}
