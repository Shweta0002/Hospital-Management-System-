package com.microservice.doctors.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.doctors.entities.Doctor;



@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long>{

	
	@Query(value = "SELECT * FROM doctor d WHERE d.name=:name",nativeQuery = true)
	Doctor findByName(@Param("name") String name);
	

}