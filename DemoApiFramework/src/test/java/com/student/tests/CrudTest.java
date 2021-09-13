package com.student.tests;

import com.github.javafaker.Faker;
import com.student.request.RequestFactory;
import com.student.spec.SpecificationFactory;
import com.student.tags.Smoke;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;

@Story("This is a CRUD testing story")
public class CrudTest extends TestBase {

    RequestFactory requestFactory = new RequestFactory();

    @Category(Smoke.class)
    @Story("This is a CRUD testing story")
    @DisplayName("This a test to get all students from the database")
    @Feature("This a test to get all students from the database")
    @Test
    public void getAllStudents() {

        requestFactory.getAllStudents()
                .then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .statusCode(200);
    }

    @Story("This is a CRUD testing story")
    @DisplayName("Create and verify a new student")
    @Feature("This a test to get all students from the database")
    @Test
    public void createNewStudent() {

        Faker fakeData = new Faker();
        String firstName = fakeData.name().firstName();
        String lastName = fakeData.name().lastName();
        String email = fakeData.internet().emailAddress();

        String programme = "ComputerScience";
        List<String> courses = new ArrayList<String>();
        courses.add("C++");
        courses.add("Java");

        requestFactory.createNewStudent("", firstName, lastName, email, programme, courses)
                .then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .statusCode(201);
    }
}
