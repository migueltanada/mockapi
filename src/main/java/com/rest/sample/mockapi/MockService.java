package com.rest.sample.mockapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class MockService {

    @Autowired
    private Environment env;


    public MockResponseDynamic retrieveMockResponseFromConfig(String config) throws JsonMappingException, JsonProcessingException{

        String jsonString = env.getProperty(String.format("mock.config.%s", config));

        System.out.println(jsonString);

        ObjectMapper objectMapper = new ObjectMapper();

        MockResponseDynamic mockResponse = new MockResponseDynamic();
        
        mockResponse.setPath(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
        
        mockResponse =  objectMapper.readValue(jsonString,MockResponseDynamic.class);

        return mockResponse;

    }
    public void retrieveMockResponseFromDb(String db, String searcQuery){
        //retrieve from db
    }
  

}
