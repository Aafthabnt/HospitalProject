package com.docter.AppointmentPortal.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DocterRole {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	
	private Long docterRoleId;
	
	//docter
	@ManyToOne(fetch = FetchType.EAGER)
	private Docter docter;
	
	@ManyToOne
	private Role role;

	

	public Long getDocterRoleId() {
		return docterRoleId;
	}

	public void setDocterRoleId(Long docterRoleId) {
		this.docterRoleId = docterRoleId;
	}

	public Docter getDocter() {
		return docter;
	}

	public void setDocter(Docter docter) {
		this.docter = docter;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	public DocterRole(Long docterRoleId, Docter docter, Role role) {
		super();
		this.docterRoleId = docterRoleId;
		this.docter = docter;
		this.role = role;
	}

	public DocterRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
