package com.paymentexample.test;

import com.jayway.restassured.http.ContentType;
import com.paymentexample.base.BaseClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class PostAsString extends BaseClass {


    @Test
    public void createPayment() {
        String msgBody = "{\\\"name\\\":\\\"test-publisher\\\",\\\"timeZone\\\":\\\"Europe/Bucharest\\\",\\\"externalReference\\\":\\\"http://google.com\\\",\\\"domain\\\":\\\"http://mypage.com\\\",\\\"techFee\\\":\\\"5.000\\\",\\\"contact\\\":\\\"John Snow\\\",\\\"email\\\":\\\"test-email@adswizz.com\\\",\\\"types\\\":[\\\"Broadcast\\\",\\\"Pure Player\\\"],\\\"genres\\\":[\\\"Movies\\\",\\\"Science\\\"],\\\"countries\\\":[\\\"RO\\\"],\\\"languages\\\":[\\\"en\\\",\\\"ro\\\"]}";
        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(accessToken)
                .when()
                .body(msgBody)
                .post("payments/payment")
                .then()
                .log()
                .all();
    }
}
