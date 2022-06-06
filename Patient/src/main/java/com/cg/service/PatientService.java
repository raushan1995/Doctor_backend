package com.cg.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cg.model.Patient;


@Service
public interface PatientService {

	
	    //post mapping
		public Patient addPatient(Patient patient);
		//get mapping
		public List<Patient> getAllPatients();
		//delete mapping
		public void deletePatientByid(int id);
	    //put mapping
		public Patient updatePatient(Patient patient);
	
	
}