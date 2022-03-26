package com.docter.AppointmentPortal.services;

import java.util.Set;

import com.docter.AppointmentPortal.entity.Docter;
import com.docter.AppointmentPortal.entity.DocterRole;

public interface DocterServices {
	public Docter createDocter(Docter docter, Set<DocterRole> docterRoles) throws Exception ;
	
	//get Docter by username
	public Docter getDocter(String username);
	
	//delete Docter by id
	public void deleteDocter(Long docterId);
}
