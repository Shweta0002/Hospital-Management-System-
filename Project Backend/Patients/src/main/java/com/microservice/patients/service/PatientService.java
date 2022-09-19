package com.microservice.patients.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.patients.entities.Patient;

@Service
public interface PatientService {

	List<Patient> getAllPatients();

	Patient getPatientDetails(Long id);

	Patient addPatient(Patient patient, Long doctorId);

}
