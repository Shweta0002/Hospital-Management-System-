package com.microservice.doctors.VO;


import com.microservice.doctors.entities.Doctor;

public class ResponseTemplateObject {
	
	private Doctor doctor;
	private Patient[] patient;
	public Doctor getCollege() {
		return doctor;
	}
	public void setCollege(Doctor college) {
		this.doctor = college;
	}
	public Patient[] getStudents() {
		return patient;
	}
	public void setStudents(Patient[] student) {
		this.patient = student;
	}
	public ResponseTemplateObject(Doctor college, Patient[] student) {
		super();
		this.doctor = college;
		this.patient = student;
	}
	public ResponseTemplateObject() {
		super();
		
	}
	
}
