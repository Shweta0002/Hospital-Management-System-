package com.microservice.patients.VO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.microservice.patients.entities.Patient;


public class Doctor {
	private Long doctorId;

	
	private String name;
	private Long age;
	private char gender;
	private String speciality;
	
	
	private Set<Patient> patients =new HashSet<>();
	
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public Set<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}
	public Doctor(Long doctorId, String name, Long age, char gender, String speciality, Set<Patient> patients) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.speciality = speciality;
		this.patients = patients;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
