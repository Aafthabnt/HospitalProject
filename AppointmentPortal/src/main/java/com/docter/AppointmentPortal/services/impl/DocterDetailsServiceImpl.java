package com.docter.AppointmentPortal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.docter.AppointmentPortal.entity.Docter;
import com.docter.AppointmentPortal.repository.DocterRepository;

@Service
public class DocterDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private DocterRepository docterRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Docter docter=this.docterRepository.findByusername(username);
		if(docter==null){
			System.out.println("Docter not found");
			throw new UsernameNotFoundException("No user found !!");
		}
		
		
		return docter;
	}

}
