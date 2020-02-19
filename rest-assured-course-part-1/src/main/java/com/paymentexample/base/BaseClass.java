package com.paymentexample.base;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;

import static com.jayway.restassured.RestAssured.given;

public class BaseClass {


   public static String accessToken;

    public static final String clientId = "";
    public static final String clientSecret = "";


    @BeforeClass
    public static void getToken() {

        RestAssured.basePath = "/v1/auth2/token";
        RestAssured.baseURI = "https://api.sandbox.paypal.com/";


        accessToken =
                given()
                        .parameters("grant_type", "client_credentials")
                        .auth()
                        .preemptive()
                        .basic(clientId, clientSecret)
                        .when()
                        .post("https://api.sandbox.paypal.com/v1/auutth2/toke")
                        .then()
                        .log()
                        .all()
                        .extract()
                        .path("access_token");

        System.out.println(accessToken);
    }

}
