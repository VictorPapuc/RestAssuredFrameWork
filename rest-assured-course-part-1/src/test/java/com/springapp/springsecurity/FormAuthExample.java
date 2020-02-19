package com.springapp.springsecurity;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.filter.session.SessionFilter;
import org.junit.BeforeClass;
import org.junit.Test;

public class FormAuthExample {

    public static SessionFilter filter;

    @BeforeClass
    public static void init() {


        //Capture sessionID
        filter = new SessionFilter();


        RestAssured.baseURI = "http://localhost:8089";
        RestAssured.given()
                .auth()
                .form("user", "user", new FormAuthConfig("/login", "uname", "pwd"))
                .filter(filter)
                .get();

        System.err.println(filter.getSessionId());
    }

      @Test
    public void getAllStudents() {

        RestAssured
                .given()
                .sessionId(filter.getSessionId())
                .get("/student/list")
                .then()
                .log()
                .all();

    }
}
