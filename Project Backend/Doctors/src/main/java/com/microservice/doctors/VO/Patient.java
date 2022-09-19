package com.microservice.doctors.VO;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.microservice.doctors.entities.Doctor;

@Entity
public class Patient {
	
	@Id
	private Long patientId;
	private String name;
	
	private Date dateOfVisit;

	private String prescription;
	public Long doctorId;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "doctorId",insertable = false,updatable = false)
	@JsonBackReference
	private Doctor visitedDoctor;

	
	public Patient(Long patientId, String name, Long doctorId, Doctor visitedDoctor, Date dateOfVisit,
			String prescription) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.doctorId = doctorId;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Doctor getVisitedDoctor() {
		return visitedDoctor;
	}

	public void setVisitedDoctor(Doctor visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
