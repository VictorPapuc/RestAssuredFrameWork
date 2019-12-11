package com.students.logging;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;
import com.student.model.Student;
import org.junit.Test;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.given;

public class LoggingRequestValues extends TestBase {

    @Test
    public void test001() {
        System.out.println("-------------------Printing request header------------------");

        Response response = given()
                                   .when()
                                   .get("/1");

        System.out.println(response.body().prettyPrint());




                given()
                .log().headers()
                        .when()
                        .get("/1")
                        .then()
                        .statusCode(200);
    }

    @Test
    public void test002() {
        System.out.println("-------------------Printing request parameters------------------");
        given()
                .param("programme", "Financial Analysis")
                .param("limit", 1)
                .log().parameters()
                .when()
                .get("/list/")
                .then()
                .statusCode(200);
    }


    @Test
    public void test003(){
        System.out.println("-------------------Printing request body------------------");


        ArrayList<String> courses = new ArrayList<>();

        courses.add("java");
        courses.add("C++");

        Student student = new Student();

        student.setFirstName("Tej");
        student.setLastName("Hegde");
        student.setEmail("xyz@gmail.com");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .log().body()
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);


    }

    @Test
    public void test004(){
        System.out.println("-------------------Printing All the  Request details------------------");

        ArrayList<String> courses = new ArrayList<>();

        courses.add("java");
        courses.add("C++");

        Student student = new Student();

        student.setFirstName("T2ej");
        student.setLastName("Hegde");
        student.setEmail("xyz@gmail.com");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }

    @Test
    public void test005(){
        System.out.println("-------------------Printing All the  Request details if validation fails------------------");

        ArrayList<String> courses = new ArrayList<>();

        courses.add("java");
        courses.add("C++");

        Student student = new Student();

        student.setFirstName("T2ej");
        student.setLastName("Hegde");
        student.setEmail("xyz@gmail.com");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .log()
                .ifValidationFails()
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }


}
