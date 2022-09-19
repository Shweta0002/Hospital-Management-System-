package com.microservice.doctors.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.doctors.controller.DoctorControlller;
import com.microservice.doctors.entities.Doctor;
import com.microservice.doctors.repository.DoctorRepo;
import com.microservice.doctors.service.DoctorService;



@WebMvcTest(DoctorControlller.class)
class DoctorTest {

	  @MockBean
	  private DoctorRepo doctorRepository;
	  
	  @MockBean
	  private DoctorService doctorService;

	  @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;

	  @Test
	  void shouldCreateDoctor() throws Exception {
	    Doctor doctor= new Doctor((long)9 , "Shalini" ,(long) 24 , 'F' , "O&G");
	    mockMvc.perform(post("/doctors").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(doctor)))
	        .andDo(print());
	  }

	  @Test
	  void shouldReturnDoctor() throws Exception {
	    int id=9;
	    String name="Shalini";
	    Doctor doctor=new Doctor((long)id, name, (long)25 , 'F', "O&G");

	    when(doctorRepository.findById((long) id)).thenReturn(Optional.of(doctor));
	    mockMvc.perform(get("/doctors/{id}", id))
	        .andDo(print());
	  }
	  


//	  @Test
//	  void shouldReturnListOfDoctors() throws Exception {
//	    List<Doctor> doctors = new ArrayList<>(
//	        Arrays.asList(new Doctor((long)9 , "Rajni" ,(long) 24 , 'F' , "orthpedic"),
//	            new Doctor((long)9 , "Tanmay" ,(long) 24 , 'M' , "urologist"),
//	            new Doctor((long)9 , "Jyoti" ,(long) 24 , 'F' , "physician")));
//
//	    when(doctorRepository.findAll()).thenReturn(doctors);
//	    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//					"/doctors").accept(
//					MediaType.APPLICATION_JSON);
//		    
//
//		 		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		 		MockHttpServletResponse response = result.getResponse();
//
//				assertEquals(200, response.getStatus());
//		 		
//	   
//	        
//	  }
	

}
