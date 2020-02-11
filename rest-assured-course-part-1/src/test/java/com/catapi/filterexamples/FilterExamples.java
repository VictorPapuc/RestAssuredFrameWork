package com.catapi.filterexamples;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.filter.log.ErrorLoggingFilter;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import org.apache.commons.io.output.WriterOutputStream;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.PrintStream;
import java.io.StringWriter;

public class FilterExamples {


    public static StringWriter requestWriter;
    public static PrintStream requestCapture;

    public static StringWriter responseWriter;
    public static PrintStream responseCapture;


    public static StringWriter errorWriter;
    public static PrintStream errorCapture;


    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost:8081";
        RestAssured.basePath = "/student";
    }


    @Before
    public void beforeEachTest() {

        requestWriter = new StringWriter();
        requestCapture = new PrintStream(new WriterOutputStream(requestWriter), true);

        responseWriter = new StringWriter();
        responseCapture = new PrintStream(new WriterOutputStream(responseWriter), true);

        errorWriter = new StringWriter();
        errorCapture = new PrintStream(new WriterOutputStream(errorWriter), true);
    }

    @Test
    public void getStudent() {
        String response = RestAssured.given()
                .log()
                .all()
                .when()
                .get("/list")
                .asString();

//        System.out.println(response);

        RestAssured
                .given()
                .filter(new RequestLoggingFilter(requestCapture))
                .filter(new ResponseLoggingFilter(responseCapture))
                .when()
                .get("/list");


        RestAssured
                .given()
                .filter(new ErrorLoggingFilter(errorCapture))
                .when()
                .get("/l22ist");

        System.err.println(requestWriter.toString());

        System.err.println(responseWriter.toString());

        System.err.println(errorWriter.toString().toUpperCase());
    }

}
