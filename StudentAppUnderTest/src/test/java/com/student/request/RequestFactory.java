package com.student.request;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.student.tests.TestBase;
import io.qameta.allure.Step;

public class RequestFactory extends TestBase {


    @Step("Getting all the students information from the database")
    public Response getAllStudents() {

        Response respons2e = RestAssured
                .given()
                .when()
                .get("/list");
        return respons2e;

    }

}
