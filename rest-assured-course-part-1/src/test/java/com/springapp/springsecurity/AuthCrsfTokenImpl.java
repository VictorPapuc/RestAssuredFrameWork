package com.springapp.springsecurity;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.filter.session.SessionFilter;
import org.junit.BeforeClass;
import org.junit.Test;

public class AuthCrsfTokenImpl {


    private static SessionFilter sessionFilter;

    @BeforeClass
    public static void init() {

        //Capture sessionID
        sessionFilter = new SessionFilter();

        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.given()
                .auth()
                .form("user", "user", new FormAuthConfig("/login", "uname", "pwd")
                        .withCsrfFieldName("_csrf"))
//                        .withAutoDetectionOfCsrf())
                .filter(sessionFilter)
                .get();

        System.err.println(sessionFilter.getSessionId());
    }

    @Test
    public void getAllStudents() {

        RestAssured
                .given()
                .sessionId(sessionFilter.getSessionId())
                .get("/student/list")
                .then()
                .log()
                .all();
    }

}
