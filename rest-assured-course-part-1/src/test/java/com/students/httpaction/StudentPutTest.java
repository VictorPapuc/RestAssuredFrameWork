package com.students.httpaction;

import com.jayway.restassured.http.ContentType;
import com.student.model.Student;
import org.junit.Test;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.given;

public class StudentPutTest {


    @Test
    public void updateStudent() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("bla");
        courses.add("bla bla");

        Student student = new Student();

        student.setFirstName("Mark");
        student.setLastName("Taylor");
        student.setEmail("xyz@gmail.com");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        student.setCourses(courses);

        given().contentType(ContentType.JSON).when().body(student).put("/101").then().statusCode(200);


    }

}
