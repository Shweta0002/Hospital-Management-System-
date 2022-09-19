package com.microservice.patients.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.http.client.methods.RequestBuilder;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.patients.controller.PatientController;
import com.microservice.patients.entities.Patient;
import com.microservice.patients.repository.PatientRepo;
import com.microservice.patients.service.PatientService;

@WebMvcTest(PatientController.class)
public class PatientTest {
	
	  @MockBean
	  private PatientRepo patientRepository;
	  
	  @MockBean
	  private PatientService patientService;

	  @Autowired
	  private MockMvc mockMvc;
	  

	  @Autowired
	  private ObjectMapper objectMapper;

	  @Test
	  void shouldCreateDoctor() throws Exception {
	    Patient patient=new Patient((long)1, "Masha", (long)1  , "Savita","Thyronorm");

	    mockMvc.perform(post("/patients").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(patient)))
	        .andDo(print());
	  }
	  String exampleJson = "{\"id\":\"pat1\",\"name\":\"Spring\",\"doctorId\":\"doc1\",\"visitedDoctor\":\"doctor\" , \"dataOfVisit\":\"date\", \"prescritption\":\"prep\"}";
	  @Test
	  void shouldReturnDoctor() throws Exception {
	    int id=9;
	    String name="Masha";
	    Patient patient=new Patient((long)1, "Masha", (long)1  , "Savita","Thyronorm");
	    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/patients/1").accept(
				MediaType.APPLICATION_JSON);
	    

	 		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	 		MockHttpServletResponse response = result.getResponse();
	 		
	 		assertEquals(200,  response.getStatus());
//	 		JSONAssert.assertEquals(exampleJson, result.getResponse()
//					.getContentAsString(), false);
}
}
	  
