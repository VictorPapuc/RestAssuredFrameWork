package com.student.base;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;

public class StudentTestBase {

    @BeforeClass
    public static void init() {
        RestAssured.basePath = "https://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";

    }

}
