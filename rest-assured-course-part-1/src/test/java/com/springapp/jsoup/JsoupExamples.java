package com.springapp.jsoup;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.filter.session.SessionFilter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsoupExamples {

    private static SessionFilter filter;

    @BeforeClass
    public static void init() {
        filter = new SessionFilter();

        RestAssured.baseURI = "http://localhost:8089";
        RestAssured.given()
                .auth()
                .form("user", "user", new FormAuthConfig("/login", "uname", "pwd"))
                .filter(filter)
                .post()
                .then();

    }

    @Test
    public void extractTitle() {

        String response = RestAssured.given().when().get("http://localhost:8089/").asString();


        Document document = Jsoup.parse(response);

        System.out.println(document.title().toUpperCase());

    }

    @Test
    public void extractingElementsByTag() {

        String response = RestAssured.given().when().get("http://localhost:8089/").asString();
        Document document = Jsoup.parse(response);

        Elements elements = document.getElementsByTag("form");

        System.out.println("The number of form elements is :" + elements.size());
        for (Element e :
                elements) {
            System.out.println(e);
        }
    }


    @Test
    public void extractingElementsById() {

        String response = RestAssured.given().when().get("http://localhost:8089/").asString();
        Document document = Jsoup.parse(response);


        Element element = document.getElementById("command");

        System.out.println("The element contents are:" + element.text());
    }


    @Test
    public void extractingLinks() {

        String response = RestAssured.given().when().get("http://localhost:8089/").asString();
        Document document = Jsoup.parse(response);


        Elements link = document.select("a[href]");

        for (Element e :
                link) {
            System.out.println(e.text());
        }
    }


    @Test
    public void extractingEmailInformation() {

        String response = RestAssured.given()
                .sessionId(filter.getSessionId())
                .when()
                .get("/student/list")
                .asString();

        Document document = Jsoup.parse(response);


        Elements emailId = document.select("table tbody tr td:nth-child(4)");

        int r = emailId.size();

        System.out.println(document + "size" + r);


        ArrayList<String> actualVal = new ArrayList<String>();

        for (Element e :
                emailId) {
            actualVal.add(e.text());
//            System.out.println(e.text());
        }


        assertThat(actualVal, hasItem("luctus.lobortis@nonbibendumsed.com"));

    }
}
