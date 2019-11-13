package com.catapi;

import com.cat.BaseCatApi;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PostInApiCat {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        String location = "/Users/victor.papuc/IdeaProjects/adswizzudemycourse/rest-assured-course-part-1/src/main/resources/files/createvote.json";

        try {
            BaseCatApi baseCatApi = objectMapper.readValue(new File(location), BaseCatApi.class);
            String jsonInString = "{\"imageId\":\"mkyong\",\"age\":37,\"}";

            BaseCatApi basecat2 = objectMapper.readValue(jsonInString, BaseCatApi.class);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
