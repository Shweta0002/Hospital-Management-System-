package com.microservice.patients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.patients.entities.Patient;



@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {

}
