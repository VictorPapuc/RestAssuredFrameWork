package com.hollidaysapi;

import com.jayway.restassured.RestAssured;
import org.junit.Test;

public class HolidayWsExample {


    @Test
    public void getHolidays() {

        String wsdUrl = "hhttp://ahahahaa.com/HolidayService.amsx?wsdl";
        String payload = "<soapemv:Evelope xmlns:soapenv";


        RestAssured.given()
                .contentType("test/xml")
                .body(payload)
                .post(wsdUrl)
                .then()
                .log()
                .all();


    }


}
