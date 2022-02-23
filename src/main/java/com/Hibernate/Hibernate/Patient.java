package com.Hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Patient {
	
	@Id
	private int patientID;
	private String patientName;
	private String patientLocation;
	
	@ManyToOne(
			cascade = CascadeType.ALL,
			targetEntity = Doctors.class,
			fetch =  FetchType.LAZY
			)
	@JoinColumn(
			name="doctorID",
			referencedColumnName = "doctorID"
			)
	
	private Doctors doctor;
	
	

	public Patient() {
		
	}
	

	public Patient(int patientID, String patientName, String patientLocation, Doctors doctor) {
		super();
		this.patientID = patientID;
		this.patientName = patientName;
		this.patientLocation = patientLocation;
		this.doctor = doctor;
	}


	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientLocation() {
		return patientLocation;
	}

	public void setPatientLocation(String patientLocation) {
		this.patientLocation = patientLocation;
	}

	public Doctors getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Patient [patientID=" + patientID + ", patientName=" + patientName + ", patientLocation="
				+ patientLocation + ", doctor=" + doctor + "]";
	}
	
	
	
	
	

}
