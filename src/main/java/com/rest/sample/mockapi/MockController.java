package com.rest.sample.mockapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import java.net.URI;
// import java.util.List;

@RestController
public class MockController {
    
    @Autowired
    private MockService service;

 
    @PostMapping("/mock/path/{path}")
    public MockResponseStatic mockResponse(@RequestBody MockRequest mock){
        
        
        MockResponseStatic mockResponse = new MockResponseStatic(
            mock.getMockCode(),
            mock.getMockDescription(),
            ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
            mock.getMockStatus(),
            mock.getBody()
        );


        return mockResponse;
    }

    @GetMapping("/mock/config/{path}")
    public MockResponseDynamic mockResponse(@PathVariable String path) throws JsonMappingException, JsonProcessingException{
                    
        return service.retrieveMockResponseFromConfig(path);
    }
    
}
