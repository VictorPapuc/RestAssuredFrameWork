package com.catapi.extractingdata;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import init.CatInit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class SearchJsonPathExample extends CatInit {

    //extract id

    @Test
    public void test001() {

        Response s =
                given()
                        .headers("x-api-key", APIKEY)
                        .when()
                        .get("/votes");
        log.info(s.prettyPrint());

        ArrayList<Integer> ids = given()
                .headers("x-api-key", APIKEY)
                .when()
                .get("/votes")
                .then()
                .extract()
                .path("id");

        for (int id : ids
        )
        {
            String ma = Integer.toString(id);
            log.info(ma);
        }
        ArrayList<Integer> idss = new ArrayList<>();
        idss.add(124474);
        Assert.assertEquals("Integer is equal to ", ids, idss);

    }

    @Test
    public void test002() {

        RequestSpecification httpRequest = RestAssured
                .given()
                .headers("x-api-key", APIKEY);

        Response response = httpRequest.get("/votes");
        JsonPath jsonPathEvaluator = response.jsonPath();
        String value  = jsonPathEvaluator.getString("id");

        System.out.println(value);

    }

}
