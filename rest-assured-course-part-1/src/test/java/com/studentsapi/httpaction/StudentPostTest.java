package com.studentsapi.httpaction;

import com.base.Student;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.given;

public class StudentPostTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
    }

    @Test
    public void createNewStudent() {

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
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }
}
