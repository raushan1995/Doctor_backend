package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.cg.model.Doctor;

import com.cg.repository.DoctorRepository;

@CrossOrigin("*")
	@RestController
	@RequestMapping("/api/v1")
	public class DoctorController {



		// doctor class
	
		@Autowired
		private DoctorRepository repository;
		
		//post mapping 
		@PostMapping("/addDoctor")
		public String saveDoctor(@RequestBody Doctor doctor) {
			repository.save(doctor);
			return "add with id: "+ doctor.getDoctorid();
		}
		//get mapping 
		
		@GetMapping("/findAllDoctor")
		public List<Doctor> getDoctors(){
			return repository.findAll();
		}
		//put mapping url
		
		@PutMapping("/update")
		public int updateDoctor(@RequestBody Doctor doctor) {
		
			return doctor.getDoctorid();
		}
//delete mapping
		@DeleteMapping("/delete/{doctorid}") // it is used to delete data into database
		public ResponseEntity<Void> deleteDoctorBydoctorid(@PathVariable int doctorid) {
		repository.deleteById(doctorid);
		return ResponseEntity.noContent().build();
		}

		
}