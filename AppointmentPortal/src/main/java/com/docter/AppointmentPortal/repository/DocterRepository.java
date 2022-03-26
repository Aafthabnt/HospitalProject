package com.docter.AppointmentPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.docter.AppointmentPortal.entity.Docter;
@Repository
public interface DocterRepository extends JpaRepository<Docter, Long>{
	public Docter findByusername(String username);
}
