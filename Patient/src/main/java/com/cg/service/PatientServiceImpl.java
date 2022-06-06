package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.cg.model.Patient;
import com.cg.repository.PatientRepository;


public class PatientServiceImpl  implements PatientService{

	private PatientRepository repository;
	private PatientService petServ;
	@Autowired
	public PatientServiceImpl(PatientRepository repository) {
		super();
		this.repository = repository;
	}

	//post mapping
	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		Patient savedPatient = repository.save(patient);
		return savedPatient;
	}
	//get mapping

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return (List<Patient>) repository.findAll();
	}

	//delete mappin
	@Override
	public  void deletePatientByid(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	//updating a record  
	public Patient updatePatient(Patient patient)   
	{  
	return repository.save(patient);  
	}

	
	


}