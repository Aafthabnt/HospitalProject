package com.docter.AppointmentPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docter.AppointmentPortal.entity.patiententity.Patient;
import com.docter.AppointmentPortal.services.PatientService;

@RestController()
@CrossOrigin("http://localhost:4200/ **")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	@PostMapping("/patients")
	public ResponseEntity<?> addPatient(@RequestBody Patient patient)
	{
		Patient patient1 = this.patientService.addPatient(patient);
		return ResponseEntity.ok(patient1);
	}
	@GetMapping("/{patientId}")
	public Patient getPatient(@PathVariable("patientId") Long patientId) {
		return this.patientService.getPatient(patientId);
	}
	@GetMapping("/patients")
		public ResponseEntity<?> getPatient()
		{
			
			return ResponseEntity.ok(this.patientService.getPatients());
		}
		
	@DeleteMapping("/{patientId}")
	public void deletePatient(@PathVariable("patientId")Long patientId) {
		this.patientService.deletePatient(patientId);
	}

}
