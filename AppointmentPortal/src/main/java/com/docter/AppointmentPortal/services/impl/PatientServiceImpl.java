package com.docter.AppointmentPortal.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.docter.AppointmentPortal.entity.patiententity.Patient;
import com.docter.AppointmentPortal.repository.PatientRepository;
import com.docter.AppointmentPortal.services.PatientService;

@Component
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return this.patientRepository.save(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return this.patientRepository.save(patient);
	}

	@Override
	public Set<Patient> getPatients() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.patientRepository.findAll());
	}

	@Override
	public Patient getPatient(Long pid) {
		// TODO Auto-generated method stub
		return this.patientRepository.getById(pid);
	}

	@Override
	public void deletePatient(Long pid) {
		// TODO Auto-generated method stub
		this.patientRepository.deleteById(pid);
	}

}
