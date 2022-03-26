package com.docter.AppointmentPortal.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docter.AppointmentPortal.entity.Docter;
import com.docter.AppointmentPortal.entity.DocterRole;
import com.docter.AppointmentPortal.repository.DocterRepository;
import com.docter.AppointmentPortal.repository.RoleRepository;
import com.docter.AppointmentPortal.services.DocterServices;

@Service
public class DocterServiceImpl implements DocterServices {
		
	@Autowired
	private DocterRepository docterRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//creating Docter
	@Override
	public Docter createDocter(Docter docter, Set<DocterRole> docterRoles) throws Exception {
		Docter local = this.docterRepository.findByusername(docter.getUsername());
		if(local!=null) {
			System.out.println("Docter is already there !!");
			throw new Exception("Docter already present !!");
		}else {
			for(DocterRole ur:docterRoles) {
				roleRepository.save(ur.getRole());
			}
			docter.getDocterRole().addAll(docterRoles);
			local = this.docterRepository.save(docter);
		}
		return local;
	}

	//getDocter by docter username
	@Override
	public Docter getDocter(String username) {
		
		return this.docterRepository.findByusername(username);
	}

	@Override
	public void deleteDocter(Long docterId) {
		
		this.docterRepository.deleteById(docterId);
		
	}

}
