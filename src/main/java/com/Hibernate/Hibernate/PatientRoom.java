package com.Hibernate.Hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class PatientRoom {
	@Id
	private int RoomNumber;
	private String RoomName;
	
	@ManyToMany(mappedBy = "roomList")
	
	
	

	public int getRoomNumber() {
		return RoomNumber;
	}
	
	public PatientRoom() {
		
	}

	public PatientRoom(int roomNumber, String roomName) {
		super();
		RoomNumber = roomNumber;
		RoomName = roomName;
	}

	public void setRoomNumber(int roomNumber) {
		RoomNumber = roomNumber;
	}
	public String getRoomName() {
		return RoomName;
	}
	public void setRoomName(String roomName) {
		RoomName = roomName;
	}
	@Override
	public String toString() {
		return "PatientRoom [RoomNumber=" + RoomNumber + ", RoomName=" + RoomName + "]";
	}
	
	
	
	

}
