package com.catapi.downloadfile;

import org.junit.Test;

import java.io.File;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FileDownloadExample {


    @Test
    public void verifyDownloadFile() {

        File inputFile = new File(System.getProperty("user.dir") + File.separator + "geckodriver-v0.26.0-macos.tar");

        //length input file
        int expectedSize = (int) inputFile.length();

        System.out.println(expectedSize);


        byte[] actualValue = given()
                .when()
                .get("https://github.com/mozilla/geckodriver/releases/download/v0.26.0/geckodriver-v0.26.0-macos.tar.gz")
                .then()
                .extract()
                .asByteArray();


        System.out.println("The size of" + actualValue);

        assertThat(expectedSize, equalTo(actualValue.length));
    }


}
