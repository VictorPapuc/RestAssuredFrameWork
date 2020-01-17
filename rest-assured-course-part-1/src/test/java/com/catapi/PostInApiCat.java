package com.catapi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PostInApiCat {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        String location = "/Users/victor.papuc/IdeaProjects/adswizzudemycourse/rest-assured-course-part-1/src/main/resources/files/createvote.json";

        try {
            BaseCatInitApi baseCatApi = objectMapper.readValue(new File(location), BaseCatInitApi.class);
            String jsonInString = "{\"imageId\":\"mkyong\",\"age\":37,\"}";

            BaseCatInitApi basecat2 = objectMapper.readValue(jsonInString, BaseCatInitApi.class);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
