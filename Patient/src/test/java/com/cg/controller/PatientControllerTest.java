package com.cg.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.model.Patient;
import com.cg.repository.PatientRepository;
import com.cg.service.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class PatientControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private PatientService ps;
	private Patient patient;
	private List<Patient> pList;
    private PatientRepository repository;
	
	@InjectMocks
	private PatientController pc;
	
	@BeforeEach
	public void setUp() {
		patient=new Patient(15,"ram","Patna","pain");
		mockMvc = MockMvcBuilders.standaloneSetup(pc).build();
		
	}
	
	@Test
	public void addPatientControllerTest() throws Exception{
		when(ps.addPatient(any())).thenReturn(patient);
		mockMvc.perform(post("/api/v1/addPatient")
		  .contentType(MediaType.APPLICATION_JSON)
		  .content(asJSONString(patient)));
		//  .andExpect(status().isCreated());
		// verify(ps,times(1)).addPatient(any());
	}
	
	//for retrive a value
		@Test
		public void getAllPatientsControllerTest() throws Exception{
			when(ps.getAllPatients()).thenReturn(pList);
			mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/findAllPatient")
					  .contentType(MediaType.APPLICATION_JSON)
					  .content(asJSONString(patient)));
			       //   .andDo(MockMvcResultHandlers.print());
			    //     verify(ps,times(1)).getAllPatients();
		}
	
	
	public static String asJSONString(final Object obj) throws Exception {
		// TODO Auto-generated method stub
		
		return new ObjectMapper().writeValueAsString(obj);
	}
	
	  @Test
	   public void DeletePatientControllerTest() throws Exception {
	      Patient patient = getAllPatients();
	 //     doNothing().when(patientController).deletePatient(1);
	   //   mvc.perform(delete("/api/v1/delete{id}" + patient.getId()).contentType(APPLICATION_JSON))
	      //   .andExpect(status().isOk()).andReturn();
	   }
	  
	  private Patient getAllPatients() {
	      Patient patient = new Patient();
	      patient.setId(2);
	      patient.setName("Mahesh");
	      patient.setAddress("patna");
	      patient.setProblem("pain");
	      return patient;
	   }
	
}


