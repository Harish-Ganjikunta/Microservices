package com.citizen.service.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizen.service.rest.entities.Citizen;
import com.citizen.service.rest.services.CitizenService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
	private Environment env;
	
	@Autowired
	private CitizenService  citizenService;
	
	@GetMapping("/sayHello")
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<>("Hello "+env.getProperty("prop.ey.value")+" welcome to Eureka", HttpStatus.OK);
	}
	
	/**
	 * {
	
	"name": "kishore",
	"vaccinationCenterId" : 665
	
}
	 * @param citizen
	 * @return
	 */
	@PostMapping("/registerCitizen")
	public ResponseEntity<Citizen> persistCitizen(@RequestBody Citizen citizen){
		return ResponseEntity.status(HttpStatus.OK).body(citizenService.saveCitizen(citizen));
	}
	
	@GetMapping("/getcitizen/{id}")
	public ResponseEntity<Citizen> getCitizen(@PathVariable("id")Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(citizenService.findCitizen(id));
	}
	
	@GetMapping("/getallcitizen")
	public ResponseEntity<List<Citizen>> getAllCitizen(){
		return ResponseEntity.status(HttpStatus.OK).body(citizenService.findAllCitizens());
	}
	
	@GetMapping("/getallCitizens/{vaccinationId}")
	public ResponseEntity<List<Citizen>> getAllCitizens(@PathVariable("vaccinationId")Integer vaccinationId){
		return ResponseEntity.status(HttpStatus.OK).body(citizenService.findAllCitizensByVaccinationId(vaccinationId));
	}
	


}
