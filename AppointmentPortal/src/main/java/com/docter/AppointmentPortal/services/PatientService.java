package com.docter.AppointmentPortal.services;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.docter.AppointmentPortal.entity.patiententity.Patient;
@Repository
public interface PatientService {
	public Patient addPatient(Patient patient);
	public Patient updatePatient(Patient patient);
	public Set<Patient> getPatients();
	public Patient getPatient(Long pid);
	public void deletePatient(Long pid);
}
