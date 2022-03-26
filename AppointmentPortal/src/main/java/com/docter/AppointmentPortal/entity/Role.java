package com.docter.AppointmentPortal.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	@Id
	private Long roleid;
	private String roleName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="role")
	private Set<DocterRole> docterRoles=new HashSet<>();
	
	
	
	
	
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(Long roleid, String roleName) {
		super();
		this.roleid = roleid;
		this.roleName = roleName;
	}
	public Set<DocterRole> getDocterRoles() {
		return docterRoles;
	}
	public void setDocterRoles(Set<DocterRole> docterRoles) {
		this.docterRoles = docterRoles;
	}
	
	
	
	
	
	

}
