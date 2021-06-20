package com.candresramirez.mutant.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.candresramirez.mutant.dto.RequestMutantDTO;
import com.candresramirez.mutant.dto.ResponseAverageDTO;
import com.candresramirez.mutant.dto.ResponseGenericDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class MutantControllerTests {

	@Autowired(required=true)
	private TestRestTemplate restTemplate;
	

    @LocalServerPort
    private int port;
    
    private String getRootUrl() {
        return "http://localhost:" + port + "/api";
    }
    
	@Test
	@DisplayName("Test Mutant")
    void mutantTest() throws JSONException, JsonProcessingException {
		
		String[] adn = {"ATGCGA","CAGTGC","TTATGT","AGAAGT","CCCCTT","TCACTT"};
		RequestMutantDTO dto = new RequestMutantDTO(); 
    	dto.setAdn(adn);
		
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<RequestMutantDTO> request = new HttpEntity<>(dto, headers);
		ResponseEntity<ResponseGenericDTO> response = this.restTemplate.postForEntity(getRootUrl() + "/mutant", request, ResponseGenericDTO.class);
	
		assertEquals(true, response.getBody().isSuccess());
    	assertEquals("OK", response.getBody().getMessage());
    }

	@Test
	@DisplayName("Test Stats Mutant")
	void statsTest() {
		String expectResult = "{\n" + 
				"  \"data\": [\n" + 
				"    {\n" + 
				"      \"id\": 1,\n" + 
				"      \"countAdnMutant\": 4,\n" + 
				"      \"countAdnHuman\": 41,\n" + 
				"      \"ratio\": 0.09\n" + 
				"    },\n" + 
				"    {\n" + 
				"      \"id\": 2,\n" + 
				"      \"countAdnMutant\": 4,\n" + 
				"      \"countAdnHuman\": 41,\n" + 
				"      \"ratio\": 0.09\n" + 
				"    }\n" + 
				"  ],\n" + 
				"  \"success\": true,\n" + 
				"  \"status\": \"OK\"\n" + 
				"}";
		
		ResponseAverageDTO response = this.restTemplate.getForObject(getRootUrl() + "/stats",  ResponseAverageDTO.class, expectResult);
		
    	assertNotNull(response.getData());
    	assertEquals(true, response.isSuccess());
	}

}
