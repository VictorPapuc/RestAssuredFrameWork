package com.catapi.downloadfile;

import org.junit.Test;

import java.io.File;

import static com.jayway.restassured.RestAssured.given;

public class FileUpload {


    @Test
    public void uploadFileExample() {

        String apiKey = "2141314";

        File inputFile = new File(System.getProperty("user.dir") + File.separator + "dancing_banana.gif");

        System.out.println(inputFile.length());

        String endpoint = "https://balblablab.com";

        given()
                .auth()
                .basic(apiKey, "")
                .multiPart("ss", inputFile)
                .multiPart("target_format", "png")
                .when()
                .post(endpoint)
                .then()
                .log()
                .all()
                .statusCode(201);
    }
}
