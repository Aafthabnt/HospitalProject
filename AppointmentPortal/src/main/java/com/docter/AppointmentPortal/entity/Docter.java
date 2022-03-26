package com.docter.AppointmentPortal.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="docters")

public class Docter implements UserDetails{
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	
	private Long id;
	private String username;
	private String Password;
	private String FirstName;
	private String LastName;
	private String Specialization;
	private String Phone;
	private boolean enabled= true;
	private String Profile;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="docter")
	@JsonIgnore
	private Set<DocterRole> docterRole=new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getProfile() {
		return Profile;
	}

	public void setProfile(String profile) {
		Profile = profile;
	}

	public Set<DocterRole> getDocterRole() {
		return docterRole;
	}

	public void setDocterRole(Set<DocterRole> docterRole) {
		this.docterRole = docterRole;
	}

	public Docter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Docter(Long id, String username, String password, String firstName, String lastName, String specialization,
			String phone, boolean enabled, String profile, Set<DocterRole> docterRole) {
		super();
		this.id = id;
		this.username = username;
		Password = password;
		FirstName = firstName;
		LastName = lastName;
		Specialization = specialization;
		Phone = phone;
		this.enabled = enabled;
		Profile = profile;
		this.docterRole = docterRole;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<Authority> set=new HashSet<>();
		
		this.docterRole.forEach(docterRole->{
			set.add(new Authority(docterRole.getRole().getRoleName()));
		});
		
		return set;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
	
	
	
}
