package com.microservice.doctors.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.doctors.Exceptions.DataNotFoundException;
import com.microservice.doctors.entities.Doctor;
import com.microservice.doctors.repository.DoctorRepo;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepo doctorRepo;
	
	@Override
	public List<Doctor> getAllDoctors() {
	
		return doctorRepo.findAll();
	}

	@Override
	public Doctor getDoctorDetails(Long doctorId) {
		return doctorRepo.findById(doctorId)
				.orElseThrow(() -> new DataNotFoundException("No Doctor found with Id : " + doctorId));
	}
	

	@Override
	public int getNumberOfPatientsAttended(Long id) {
		
		 return getDoctorDetails(id).getPatients().size();
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		
		return doctorRepo.save(doctor);
	}

	@Override
	public Doctor getDoctorByName(String docName) {
		
		return doctorRepo.findByName(docName);
	}

}
