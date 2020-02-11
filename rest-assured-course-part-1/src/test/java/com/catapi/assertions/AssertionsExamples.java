package com.catapi.assertions;

import com.catapi.init.CatInit;
import com.jayway.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Slf4j
public class AssertionsExamples extends CatInit {


    @Test
    public void test001() {

        Response request =
                given()
                        .headers("x-api-key", APIKEY)
                        .when()
                        .get("/votes");

        //GET Request
        log.info(request.prettyPrint());


        ArrayList<Integer> ids = given()
                .headers("x-api-key", APIKEY)
                .when()
                .get("/votes")
                .then()
                .extract()
                .path("id");

        for (int id : ids
        ) {
            String idField = Integer.toString(id);
            //log doesn't print the value.
            System.out.println(idField);
        }

        ArrayList<Integer> expectedId = new ArrayList<>();
        expectedId.add(124474);
        Assert.assertEquals("Integer is equal to ", ids, expectedId);
    }


    @Test
    public void test002() {


        given()
                .headers("x-api-key", APIKEY)
                .when()
                .get("/votes")
                .then()
                //Hamcrest for Object Json
                .body("id", equalTo(1));

//        log.info();

    }

    @Test
    public void test003() {

        given()
                .headers("x-api-key", APIKEY)
                .when()
                .get("/votes")
                .then()

                //Hamcrest for Array Json Multiple Assertions
                .body("id", hasItem(124474))
                .body("ss", hasItem(221212))
                .body("ss", hasItem(221212))
                .body("ss", hasItem(221212))
                .statusCode(200);

//        log.info();

    }


    @Test
    public void test004() {

        given()
                .headers("x-api-key", APIKEY)
                .when()
                .get("/votes")
                .then()

                //Hamcrest Assertions with operators.
                .body("id", equalTo(124474))
                .body("ss", greaterThan(221212))
                .body("ss", lessThanOrEqualTo(221212))
                .body("ss", hasItem(221212))
                .statusCode(200);

//        log.info();

    }

}
