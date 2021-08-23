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

import io.swagger.v3.oas.annotations.Operation;

// import java.net.URI;
// import java.util.List;

@RestController
public class MockController {
    
    @Autowired
    private MockService service;

    @Operation(summary = "Mock by json body", description = "Send whatever is in path and request body. Path field is always included in the response!")
    @PostMapping("/mock/path/{path}")
    public MockResponseStatic mockResponse(@RequestBody MockRequest mock, @PathVariable String path){
        
        
        MockResponseStatic mockResponse = new MockResponseStatic(
            mock.getMockCode(),
            mock.getMockDescription(),
            String.format("%s/%s",ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),path),
            mock.getMockStatus(),
            mock.getBody()
        );


        return mockResponse;
    }

    @Operation(summary = "Mock by reading json from config file", description = "Send whatever is in application.properties file. select the property using request path. Path field is always included in the respones, unless it is available in application.propreties!")
    @GetMapping("/mock/config/{path}")
    public MockResponseDynamic mockResponse(@PathVariable String path) throws JsonMappingException, JsonProcessingException{
                    
        return service.retrieveMockResponseFromConfig(path);
    }
    
}
