package com.studentsapi.logging;

import com.student.base.StudentTestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class LoggingResponsetValues extends StudentTestBase {

    @Test
    public void test002() {
        System.out.println("-------------------Printing response headers------------------");
        given()
                .param("programme", "Financial Analysis")
                .param("limit", -1)
                .log().parameters()
                .when()
                .get("/list/")
                .then()
                .log()
                .ifError();
//                .body()
//                .status()
//                .headers()
//                .statusCode(200);
    }

}