package com.microservice.patients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.patients.VO.Doctor;
import com.microservice.patients.entities.Patient;
import com.microservice.patients.service.PatientService;


@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	public PatientService service;
	
	
	@GetMapping
	private ResponseEntity<List<Patient>> getPatients() {
		try {
			List<Patient> patients = service.getAllPatients();
			if (patients.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	private ResponseEntity<?> getPatient(@PathVariable Long id) {
		try {
			Patient patient = service.getPatientDetails(id);
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);

		} catch (Exception e) {
			if (e.getMessage().contains("No Patient found with Id :"))
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/{doctorId}")
	private ResponseEntity<?> addPatient(@RequestBody Patient patient, @PathVariable Long doctorId) {
		try {
			Patient patient1 = service.addPatient(patient, doctorId);
			return new ResponseEntity<Patient>(patient1, HttpStatus.CREATED);

		} catch (Exception e) {
			if (e.getMessage().contains("No Doctor found with Id :"))
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
