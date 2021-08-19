package com.rest.sample.mockapi;

import java.util.Map;

public class MockResponseStatic {
    
    private String code;

    private String description;

    private String path;

    private String status;

    private Map<String,Object> body;


    public MockResponseStatic ( String code, String description, String path, String status, Map<String, Object> body){
        
        this.code = code;
        
        this.description = description;
        
        this.path = path;
        
        this.status = status;
        
        this.body = body;
        
    }
    
    public MockResponseStatic (){}

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
       return code;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
       return description;
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
       return path;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
       return status;
    }

    public void setBody(Map<String, Object> body){
        this.body = body;
    }

    public Map<String,Object> getBody(){
       return body;
    }
    
    @Override
    public String toString(){
        return String.format("message [code=%s, description=%s, path=%s, status=%s]", code, description, path, status);
    }




}
