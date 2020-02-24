package com.student.tests;

import com.student.util.PropertyReader;
import org.junit.BeforeClass;
import io.restassured.RestAssured;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestBase {


    public static PropertyReader propertyReader;

    @Rule
    public TestRule testRule = new TestWatcher() {

        @Override
        protected void succeeded(Description description){

        }
    };

    @BeforeClass
    public static void initUrl() {

        propertyReader = PropertyReader.getInstance();

        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.port = Integer.valueOf(propertyReader.getProperty("port"));

    }
}
