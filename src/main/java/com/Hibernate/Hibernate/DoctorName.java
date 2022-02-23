package com.Hibernate.Hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class DoctorName {

	private String firstNmae;
	private String lastName;
	public String getFirstNmae() {
		return firstNmae;
	}
	public void setFirstNmae(String firstNmae) {
		this.firstNmae = firstNmae;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "DoctorName [firstNmae=" + firstNmae + ", lastName=" + lastName + "]";
	}
	
	
}
