package com.student.tests;

import com.student.request.RequestFactory;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Story("This is a CRUD testing story")
public class CrudTest extends TestBase {

    RequestFactory requestFactory = new RequestFactory();

    @Story("This is a CRUD testing story")
    @DisplayName("This a test to get all students from the database")
    @Feature("This a test to get all students from the database")
    @Test
    public void getAllStudents() {

        requestFactory.getAllStudents().then().statusCode(200);

    }
}
