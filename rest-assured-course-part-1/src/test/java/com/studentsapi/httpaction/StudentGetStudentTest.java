package com.studentsapi.httpaction;


import com.jayway.restassured.response.Response;
import com.student.base.StudentTestBase;
import com.student.endpoint.Path;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
@RequiredArgsConstructor
public class StudentGetStudentTest extends StudentTestBase {

      private String listPath = Path.List.getPath();

    @Test
    public void getAllStudentsInformation() {
        Response response = given().when().get(listPath);
        log.info((response.body().prettyPrint()));
        given().when().get("/list").then().statusCode(200);
    }

    @Test
    public void getStudentInfo() {
        Response response = given().when().get("/1");
        log.info(response.body().prettyPrint());
        given().when().get("/1").then().statusCode(200);

    }

    @Test
    public void getStudentsFromFA() {

        Response response = given().when().get("/list?programme=Financial Analysis&limit=2");
        final String prettyPrintResponse = response.body().prettyPrint();
        log.info(prettyPrintResponse);

        Response response1 = given().param("programme", "Financial Analysis").param("limit", 2).when().get("/list");
        String prettyPrintResponse1 = String.valueOf(response1.body().prettyPeek());
        log.info(prettyPrintResponse1);
    }


}

