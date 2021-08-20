package com.rest.sample.mockapi;

import java.util.Map;


public class MockRequest {

    private String mockCode;

    private String mockDescription;

    private String mockStatus;

    private int mockHttpCode;

    private Map<String,Object> mockBody;

    public MockRequest ( String mockCode, String mockDescription, int mockHttpCode, String mockStatus, Map<String, Object> mockBody){
        
        this.mockCode = mockCode;

        this.mockDescription = mockDescription;

        this.mockHttpCode = mockHttpCode;

        this.mockStatus = mockStatus;
        
        this.mockBody = mockBody;
        
    }
    
    public MockRequest (){}
    
    public void setMockCode(String mockCode){
        this.mockCode = mockCode;
    }

    public String getMockCode(){
       return mockCode;
    }

    public void setMockDescription(String mockDescription){
        this.mockDescription = mockDescription;
    }

    public String getMockDescription(){
       return mockDescription;
    }

    public void setMockHttpCode(int mockHttpCode){
        this.mockHttpCode = mockHttpCode;
    }

    public int getMockHttpCode(){
       return mockHttpCode;
    }

    public void setMockStatus(String mockStatus){
        this.mockStatus = mockStatus;
    }

    public String getMockStatus(){
       return mockStatus;
    }

    public void setMockBody(Map<String, Object> mockBody){
        this.mockBody = mockBody;
    }

    public Map<String,Object> getBody(){
       return mockBody;
    }
    

    @Override
    public String toString(){
        return String.format("message [code=%s, description=%s, path=%s, status=%s]", mockCode, mockDescription, mockHttpCode, mockStatus);
    }




}
