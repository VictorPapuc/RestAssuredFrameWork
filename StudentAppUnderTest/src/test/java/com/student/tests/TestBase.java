package com.student.tests;

import com.jayway.restassured.RestAssured;
import com.student.util.PropertyReader;
import org.junit.BeforeClass;

public class TestBase {


    public static PropertyReader propertyReader;

    @BeforeClass
    public static void initUrl() {

        propertyReader = PropertyReader.getInstance();

        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.port = Integer.valueOf(propertyReader.getProperty("port"));

    }
}
