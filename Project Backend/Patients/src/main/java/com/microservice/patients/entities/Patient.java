 package com.microservice.patients.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.microservice.patients.VO.Doctor;



@Entity
@Table(name="Patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;

	
	private String name;
	private Long doctorId;
	

	private String visitedDoctor;
	
	@CreationTimestamp
	private Date dateOfVisit;

	private String prescription;

	protected Patient() {

	}

	

	public Long getDoctorId() {
		return doctorId;
	}



	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}



	

	


	public Patient( String name, Long doctorId,Date dateOfVisit,
			String prescription) {
		super();
	
		this.name = name;
		this.doctorId = doctorId;
		this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
	}

	public Patient( Long PatId , String name, Long doctorId,String visitedDoctor , 
			String prescription) {
		super();
		this.patientId=PatId;
		this.visitedDoctor=visitedDoctor;
		this.name = name;
		this.doctorId = doctorId;
		//this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
	}



	public String getVisitedDoctor() {
		return visitedDoctor;
	}



	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}



	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the visitedDoctor
	 */
	

	/**
	 * @param visitedDoctor the visitedDoctor to set
	 */
	
	/**
	 * @return the dateOfVisit
	 */
	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	/**
	 * @param dateOfVisit the dateOfVisit to set
	 */
	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	/**
	 * @return the prescription
	 */
	public String getPrescription() {
		return prescription;
	}

	/**
	 * @param prescription the prescription to set
	 */
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", visitedDoctor=" + visitedDoctor
				+ ", dateOfVisit=" + dateOfVisit + ", prescription=" + prescription + "]";
	}

}
