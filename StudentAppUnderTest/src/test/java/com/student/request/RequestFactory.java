package com.student.request;

import com.github.javafaker.Faker;
import com.student.pojo.StudentClass;
import com.student.tests.TestBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

public class RequestFactory extends TestBase {
    RestClient restClient = new RestClient();

    @Step("Getting all the students information from the database")
    public Response getAllStudents() {

        Response response = restClient.doGetRequest("/list");
        return response;
    }

    @Step("Creating new student :{0} , {1} , {2} , {3} , {4}")
    public Response createNewStudent(String url, String firstName, String lastName, String email, String programme, List<String> courses) {

        StudentClass studentClass = new StudentClass();
        studentClass.setFirstName(firstName);
        studentClass.setLastName(lastName);
        studentClass.setEmail(email);
        studentClass.setProgramme(programme);
        studentClass.setCourses(courses);

        return restClient.doPostRequest(url, studentClass);

    }
}
