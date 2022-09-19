package com.microservice.doctors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.doctors.entities.Doctor;

@Service
public interface DoctorService {

	List<Doctor> getAllDoctors();

	Doctor getDoctorDetails(Long id);

	Doctor addDoctor(Doctor doctor);

	int getNumberOfPatientsAttended(Long id);

	Doctor getDoctorByName(String docName);

}
