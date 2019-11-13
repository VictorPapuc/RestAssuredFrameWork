package com.catapi;

import com.cat.BaseCatApi;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PostInApiCat1 {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        BaseCatApi baseCatApi = createStaff();

        String location = "/Users/victor.papuc/IdeaProjects/adswizzudemycourse/rest-assured-course-part-1/src/main/resources/files/createvote.json";
        try {

            objectMapper.writeValue(new File(location), baseCatApi);

            String jsonString = objectMapper.writeValueAsString(baseCatApi);

            System.out.println(jsonString);
            String jsonInString2 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(baseCatApi);

            System.out.println(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static BaseCatApi createStaff() {

        BaseCatApi catApi = new BaseCatApi();
        catApi.setImageId("ss");
        catApi.setSubId("ss");
        catApi.setValue(2);
        return catApi;
    }


}
