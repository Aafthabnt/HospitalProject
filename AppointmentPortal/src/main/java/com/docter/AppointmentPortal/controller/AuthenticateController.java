package com.docter.AppointmentPortal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.docter.AppointmentPortal.entity.Docter;
import com.docter.AppointmentPortal.entity.JwtRequest;
import com.docter.AppointmentPortal.entity.JwtResponse;
import com.docter.AppointmentPortal.security.JwtUtil;
import com.docter.AppointmentPortal.services.impl.DocterDetailsServiceImpl;

@CrossOrigin("http://localhost:4200/ **")
@RestController
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private DocterDetailsServiceImpl docterDetailsService;
	
	@Autowired
	private JwtUtil jwtUtils;
	
	
	//generate token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
			
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Docter not found");
		}
		
		UserDetails userDetails = this.docterDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		
		
		
		
	}
	
	private void authenticate(String username,String password) throws Exception
	{
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
			
		}catch(DisabledException e) {
			throw new Exception("User DISABLED"+e.getMessage());
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid Credentials "+e.getMessage());
		}
		
		
		
	}
	
	@GetMapping("/current-user")
	public Docter getCurrrent(Principal principal) {
		return ((Docter) this.docterDetailsService.loadUserByUsername(principal.getName()));
		
	}
}
