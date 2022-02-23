package com.Hibernate.Hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Doctors {
	
	@Id
	//@GeneratedValue(st)
	private int doctorID;
	@Embedded
	private DoctorName name;
	private String hospital;
	private String specialist;
	
	@OneToOne(
			
			cascade = CascadeType.ALL,
			
			targetEntity = Office.class,
			fetch = FetchType.LAZY
			)
	@JoinColumn(
			name="office_id",
			referencedColumnName = "officeID"
			)
	private Office office;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	
	@JoinTable(
			name="doctor_room",
			joinColumns = @JoinColumn(
					name="doctor_id",
					referencedColumnName = "doctorID"
					),
			inverseJoinColumns = @JoinColumn(
					name="room_id",
					referencedColumnName = "RoomNumber"
					)
			
			)
	private List<PatientRoom> roomList;
	

	
	
	public Doctors(int doctorID, DoctorName name, String hospital, String specialist) {
		super();
		this.doctorID = doctorID;
		this.name = name;
		this.hospital = hospital;
		this.specialist = specialist;
	}


	Doctors(){
		
	}
	
	
	
	

	public List<PatientRoom> getRoomList() {
		return roomList;
	}


	public void setRoomList(List<PatientRoom> roomList) {
		this.roomList = roomList;
	}


	public Office getOffice() {
		return office;
	}


	public void setOffice(Office office) {
		this.office = office;
	}


	public DoctorName getName() {
		return name;
	}


	public void setName(DoctorName name) {
		this.name = name;
	}


	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}


	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	@Override
	public String toString() {
		return "Doctors [doctorID=" + doctorID + ", name=" + name + ", hospital=" + hospital + ", specialist="
				+ specialist + "]";
	}
	
	
	
	

}
