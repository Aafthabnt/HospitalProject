package com.docter.AppointmentPortal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.docter.AppointmentPortal.entity.Docter;
import com.docter.AppointmentPortal.entity.DocterRole;
import com.docter.AppointmentPortal.entity.Role;
import com.docter.AppointmentPortal.services.DocterServices;

@SpringBootApplication
public class AppointmentPortalApplication implements CommandLineRunner {
	
	@Autowired
	private DocterServices docterService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptoPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(AppointmentPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");
		
//		Docter docter = new Docter();
//		
//		docter.setFirstName("Aafthab");
//		docter.setLastName("Tumminakatti");
//		docter.setUsername("Aafthab001");
//		docter.setPassword(this.bCryptoPasswordEncoder.encode("abc"));
//		docter.setSpecialization("Surgeon");
//		docter.setPhone("9968753071");
//		
//		Role role1=new Role();
//		role1.setRoleid(44L);
//		role1.setRoleName("ADMIN");
//		
//		Set<DocterRole> docterRoleSet=new HashSet<>();
//		DocterRole docterRole=new DocterRole();
//		docterRole.setRole(role1);
//		docterRole.setDocter(docter);
//		
//		docterRoleSet.add(docterRole);
//		Docter docter1=this.docterService.createDocter(docter, docterRoleSet);
//		System.out.println(docter1.getUsername());
	}

}
