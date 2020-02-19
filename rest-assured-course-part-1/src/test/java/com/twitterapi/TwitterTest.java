package com.twitterapi;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class TwitterTest {

    String consumerKey = "";
    String consumerSecret = "";
    String accessTokenSecret = "";
    String secretToken = "";

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "";
        RestAssured.basePath = "";
    }

    @Test
    public void createTweet() {

        given()
                .auth()
                .oauth(consumerKey, consumerSecret, accessTokenSecret, secretToken)
                .queryParam("status", "This is my first tweet from RestAssured")
                .when()
                .post("/update.json")
                .then()
                .log()
                .all();
    }

    @Test
    public void geTweet() {

        given()
                .auth()
                .oauth(consumerKey, consumerSecret, accessTokenSecret, secretToken)
                .queryParam("status", "This is my first tweet from RestAssured")
                .log()
                .all()
                .when()
                .get("/user_timeline.json")
                .then()
                .log().all();

    }
}
