package com.test.pamcase.controller;

import java.util.Base64;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.pamcase.dto.CaseDTO;

//import com.springboot.testkafka.dto.CaseDTO;

@RestController
public class CreateCaseController {

	private RestTemplate restTemplate = new RestTemplate();
	
	/*
	private final RestTemplate restTemplate;
	
	CreateCaseController(RestTemplateBuilder restTemplateBuilder){
		this.restTemplate=restTemplateBuilder.basicAuthentication("wbadmin", "wbadmin").build();
	}
	
	*/
	@PostMapping("/local-case")
	public  ResponseEntity<String> CreateCaseapi(@RequestBody CaseDTO casedto){
		
	
String url="http://localhost:8080/kie-server/services/rest/server/containers/caseProject2_1.0.0-SNAPSHOT/cases/caseProject2.casedef1/instances";

HttpHeaders headers2 = new HttpHeaders();

//headers2.set("Authorization", "Basic" +Base64.g)

headers2.setBasicAuth("wbadmin", "wbadmin");

headers2.setContentType(MediaType.APPLICATION_JSON);

HttpEntity<String> request = new HttpEntity<>(headers2);

/*ResponseEntity<CaseDTO> response = restTemplate
  .exchange(url, HttpMethod.POST, request, CaseDTO.class); 
System.out.println("post dato"+response.toString());

*/

ResponseEntity<String> response = restTemplate
.exchange(url, HttpMethod.POST, request, String.class); 
System.out.println("post string"+response);

return response;

}
	
	@GetMapping("/local-case")
	public  ResponseEntity<String> getCaseapi(){
		
	
String url="http://localhost:8080/kie-server/services/rest/server/containers/caseProject2_1.0.0-SNAPSHOT/cases/instances/CASE-0000000011/nodes/instances?completed=false&page=0&pageSize=10";

HttpHeaders headers2 = new HttpHeaders();

//headers2.set("Authorization", "Basic" +Base64.getEncoder().encodeToString(null))

headers2.setBasicAuth("wbadmin", "wbadmin");
headers2.setContentType(MediaType.APPLICATION_JSON);

HttpEntity<String> request = new HttpEntity<>(headers2);
ResponseEntity<String> response = restTemplate
  .exchange(url, HttpMethod.GET, request, String.class); 

System.out.println("response ="+response);
return response;

}
}