package com.docter.AppointmentPortal.entity.patiententity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long pid;
	private String name;
	private String gender;
	private int age;
	private String specialization;
	private String dateofvist;
	private String phoneNumber;
	private String visitedDocter;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDateofvist() {
		return dateofvist;
	}
	public void setDateofvist(String dateofvist) {
		this.dateofvist = dateofvist;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getVisitedDocter() {
		return visitedDocter;
	}
	public void setVisitedDocter(String visitedDocter) {
		this.visitedDocter = visitedDocter;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(Long pid, String name, String specialization, String dateofvist, String phoneNumber,
			String visitedDocter) {
		super();
		this.pid = pid;
		this.name = name;
		this.specialization = specialization;
		this.dateofvist = dateofvist;
		this.phoneNumber = phoneNumber;
		this.visitedDocter = visitedDocter;
	}
	
	
}
