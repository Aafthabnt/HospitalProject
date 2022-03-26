package com.docter.AppointmentPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docter.AppointmentPortal.entity.patiententity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
