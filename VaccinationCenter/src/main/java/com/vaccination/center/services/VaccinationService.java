package com.vaccination.center.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vaccination.center.entities.VaccinationCenter;
import com.vaccination.center.models.Citizen;
import com.vaccination.center.models.VaccinationResponse;
import com.vaccination.center.repositories.VaccinationCenterRepository;

@Service
public class VaccinationService {
	
	@Autowired
	private VaccinationCenterRepository vaccinationCenterRepository;
	
	@Autowired
	private RestTemplate restTemplate; 
	
	public VaccinationCenter saveVaccinationCenter(VaccinationCenter center) {
		return vaccinationCenterRepository.saveAndFlush(center);
	}
	
	public VaccinationCenter findVaccinationByID(Integer id) {
		return vaccinationCenterRepository.findById(id).get();
	}
	
	public List<VaccinationCenter> findAllVaccinationCenters(){
		return vaccinationCenterRepository.findAll();
	}
	
	@SuppressWarnings("unchecked")
	public VaccinationResponse findVaccinationCenterResponse(Integer vaccineId){
		VaccinationResponse response  =  new VaccinationResponse();
		VaccinationCenter vaccineCenter= vaccinationCenterRepository.findById(vaccineId).get();
		response.setVaccinationCenter(vaccineCenter);
		//List<Citizen> citizens = restTemplate.getForObject("http://localhost:8086/citizen/getallCitizens/"+vaccineId, List.class);
		List<Citizen> citizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/getallCitizens/"+vaccineId, List.class);
		response.setCitizens(citizens);
		return response;
	}



}
