package com.citizen.service.rest.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citizen.service.rest.entities.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer>{
	
	public List<Citizen> findByVaccinationCenterId(Integer vaccineId);

}
