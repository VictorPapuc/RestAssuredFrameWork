package com.catapi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Test {


    public String s = "/Users/victor.papuc/IdeaProjects/adswizzudemycourse/rest-assured-course-part-1/src/main/resources/files/createvote.json";

    public static String location = "/Users/victor.papuc/IdeaProjects/adswizzudemycourse/rest-assured-course-part-1/src/main/resources/files/staff.json";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // JSON file to Java object
            Staff staff = mapper.readValue(new File(location), Staff.class);


            // JSON string to Java object
            String jsonInString = "{\"name\":\"mkyong\",\"age\":37,\"skills\":[\"java\",\"python\"]}";
            Staff staff2 = mapper.readValue(jsonInString, Staff.class);

            // compact print
            System.out.println(staff2);

            // pretty print
            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff2);

            System.out.println(prettyStaff1);


        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}



