package com.rest.sample.mockapi;

import java.util.Map;


public class MockRequest {

    private String mockCode;

    private String mockDescription;

    private String mockStatus;

    private int mockHttpCode;

    private Map<String,Object> mockBody;

    public MockRequest ( String code, String description, int httpCode, String status, Map<String, Object> body){
        
        this.mockCode = code;

        this.mockDescription = description;

        this.mockHttpCode = httpCode;

        this.mockStatus = status;
        
        this.mockBody = body;
        
    }
    
    public MockRequest (){}
    public void setMockCode(String code){
        this.mockCode = code;
    }

    public String getCode(){
       return mockCode;
    }

    public void setMockDescription(String description){
        this.mockDescription = description;
    }

    public String getMockDescription(){
       return mockDescription;
    }

    public void setMockHttpCode(int httpCode){
        this.mockHttpCode = httpCode;
    }

    public int getMockHttpCode(){
       return mockHttpCode;
    }

    public void setMockStatus(String status){
        this.mockStatus = status;
    }

    public String getStatus(){
       return mockStatus;
    }

    public void setMockBody(Map<String, Object> body){
        this.mockBody = body;
    }

    public Map<String,Object> getBody(){
       return mockBody;
    }
    

    @Override
    public String toString(){
        return String.format("message [code=%s, description=%s, path=%s, status=%s]", mockCode, mockDescription, mockHttpCode, mockStatus);
    }




}
