package com.citizen.service.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citizen.service.rest.daos.CitizenRepository;
import com.citizen.service.rest.entities.Citizen;

@Service
public class CitizenService {
	
	@Autowired
	private CitizenRepository  citizenRepository;
	
	public Citizen  saveCitizen(Citizen citizen) {
		return citizenRepository.saveAndFlush(citizen);
		
	}
	
	public Citizen findCitizen(Integer id) {
		return citizenRepository.findById(id).get();
	}
	
	public List<Citizen> findAllCitizens(){
		return citizenRepository.findAll();
	}
	
	public List<Citizen> findAllCitizensByVaccinationId(Integer vaccineId){
		return citizenRepository.findByVaccinationCenterId(vaccineId);
	}

}
