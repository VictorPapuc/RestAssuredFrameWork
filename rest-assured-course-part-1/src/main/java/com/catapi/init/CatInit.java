package com.catapi.init;

import com.jayway.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;

@Slf4j
public class CatInit {

    public static final String APIKEY = "f0010f87-9860-4c13-949f-27afd7299098";

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "https://api.thecatapi.com/";
        RestAssured.basePath = "/v1";
    }

}


