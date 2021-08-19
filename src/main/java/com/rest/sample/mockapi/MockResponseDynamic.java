package com.rest.sample.mockapi;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;


public class MockResponseDynamic {
    

    private String path;

    Map<String, Object> property = new LinkedHashMap<>();


    public MockResponseDynamic (String path){
        this.path = path;
    }
    
    public MockResponseDynamic (){}

    //  Get set for heavy weather!
    @JsonAnySetter
    public void setProperty(String key, Object value) {
        property.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getProperty() {
        return property;
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
       return path;
    }


    // @Override
    // public String toString(){
    //     return String.format("message [path=%s]", path);
    // }




}
