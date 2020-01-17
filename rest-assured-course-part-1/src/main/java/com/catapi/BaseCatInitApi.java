package com.catapi;

import com.jayway.restassured.RestAssured;
import org.junit.Test;

public class BaseCatInitApi {

    public String imageId;
    public String subId;
    public int value;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static final String APIKEY = "f0010f87-9860-4c13-949f-27afd7299098";

    @Test
    public static void init() {
        RestAssured.baseURI = "https://api.thecatapi.com/";
        RestAssured.basePath = "/v1";
    }


}
