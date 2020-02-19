package com.studentsapi.httpaction;

import com.student.base.StudentTestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class StudentDeleteStudentTest extends StudentTestBase {


    @Test
    public void deleteStudentTest() {

        given().when().delete("/101").then().statusCode(204);

    }


}
