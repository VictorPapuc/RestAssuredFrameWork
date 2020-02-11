package com.catapi.assertions;

import com.jayway.restassured.RestAssured;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class SofAssertions {


    @Test
    public void hardAsserts() {
        RestAssured.given()
                .when()
                .get("http://localhost:8081/student/list")
                .then()
                .body("[0].firstName", equalTo("Vernson"))
                .body("[0].lastName", equalTo("Harper"))
                .body("[0].email", equalTo("egestas.rhoncus.Proin@massaQuisqueporttitor.org"))
                .body("[0].programme", equalTo("Financial Analysis"));


//
    }

    @Test
    public void softAsserts() {
        RestAssured.given()
                .when()
                .get("http://localhost:8081/student/list")
                .then()
                .body("[0].firstName", equalTo("Vernson"),
                        "[0].lastName", equalTo("Harper"),
                        "[0].email", equalTo("egestas.rhoncus.Psroin@massaQuisqueporttitor.org"),
                        "[0].programme", equalTo("Financial Analysis"));
    }

}
