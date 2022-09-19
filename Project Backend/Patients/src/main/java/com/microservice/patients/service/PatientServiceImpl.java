package com.microservice.patients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.microservice.patients.Exception.DataNotFoundException;
import com.microservice.patients.VO.Doctor;
import com.microservice.patients.VO.ResponseTemplateObject;
import com.microservice.patients.entities.Patient;
import com.microservice.patients.repository.PatientRepo;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepo patientRepo;
	@Autowired
	private RestTemplate restTemplate; 
	
	
	
	
	@Override
	public List<Patient> getAllPatients() {
		return patientRepo.findAll();
	}


	@Override
	public Patient getPatientDetails(Long patientId) {
		return patientRepo.findById(patientId)
				.orElseThrow(() -> new DataNotFoundException("No Patient found with Id : " + patientId));
	}

	@Override
	public Patient addPatient(Patient patient, Long doctorId) {
		ResponseEntity<Doctor> doc= restTemplate.getForEntity("http://DOCTOR-SERVICE/doctors/"+doctorId, 
				Doctor.class);
		Doctor visitedDoctor=doc.getBody();
		//Long DocId = visitedDoctor.getDoctorId();
		patient.setVisitedDoctor(visitedDoctor.getName());
		patient.setDoctorId(doctorId);
		return patientRepo.save(patient);
		//Doctor  = doctorRepo.findById(doctorId)
		//.orElseThrow(() -> new DataNotFoundException("No Doctor found with Id : " + doctorId));
	}

}
