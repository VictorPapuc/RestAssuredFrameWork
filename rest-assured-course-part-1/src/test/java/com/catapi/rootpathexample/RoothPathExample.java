package com.catapi.rootpathexample;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;

import java.util.HashMap;

public class RoothPathExample {


    static HashMap<String, Object> parameters = new HashMap<String, Object>();

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "";
        RestAssured.basePath = "";
        RestAssured.rootPath = "";

        parameters.put("q", "select * from yahoo.finance.xchange where piar in (");
        parameters.put("format", "json");
        parameters.put("env", "store://datatables.org/alltableswitchkeys");

    }

}
