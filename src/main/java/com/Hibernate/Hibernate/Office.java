package com.Hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Office {
	@Id
	private int officeID;
	private String officeName;
	public int getOfficeID() {
		return officeID;
	}
	public void setOfficeID(int officeID) {
		this.officeID = officeID;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
	
	@Override
	public String toString() {
		return "Office [officeID=" + officeID + ", officeName=" + officeName + "]";
	}
	
	

}
