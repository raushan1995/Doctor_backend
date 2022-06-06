package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.model.Patient;
import com.cg.repository.PatientRepository;
import com.cg.service.PatientService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class PatientController {


	//from patient service
	
	@Autowired
	private PatientRepository repository;
	
	private PatientService petServ;
	
	//post mapping
	
	@PostMapping("/addPatient")
	public String savePatient(@RequestBody Patient patient) {
		repository.save(patient);
		return "add with id: "+ patient.getId();
	}
	//get mapping
	
	@GetMapping("/findAllPatient")
	public List<Patient> getPatients(){
		return repository.findAll();
	}
	
	@PutMapping("/update") // it is used to update data into database
	private Patient update(@RequestBody Patient patient)   
	{  
	petServ.updatePatient(patient);  
	return patient;  
	}  
	
	@DeleteMapping("/delete/{id}") // it is used to delete data into database
	public ResponseEntity<Void> deletepatientById(@PathVariable int id) {
	repository.deleteById(id);
	return ResponseEntity.noContent().build();
	}
}