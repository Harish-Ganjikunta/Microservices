package com.vaccination.center.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccination.center.entities.VaccinationCenter;
import com.vaccination.center.models.VaccinationResponse;
import com.vaccination.center.services.VaccinationService;

@RestController
@RequestMapping("/vaccination-center")
public class VaccinationCenterController {
	
	@Autowired
	private VaccinationService vaccinationService;
	
	@GetMapping("/get")
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<>("Hello Vaccination center", HttpStatus.OK);
	}
	
	@PostMapping("/registerVaccinationCenter")
	public ResponseEntity<VaccinationCenter> persistCitizen(@RequestBody VaccinationCenter center){
		return ResponseEntity.status(HttpStatus.OK).body(vaccinationService.saveVaccinationCenter(center));
	}
	
	
	@GetMapping("/getVaccinationcenter/{id}")
	public ResponseEntity<VaccinationCenter> getCitizen(@PathVariable("id")Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(vaccinationService.findVaccinationByID(id));
	}
	
	@GetMapping("/getallvaccinationcenters")
	public ResponseEntity<List<VaccinationCenter>> getAllCitizen(){
		return ResponseEntity.status(HttpStatus.OK).body(vaccinationService.findAllVaccinationCenters());
	}
	
	@GetMapping("/getallvaccinationcenters/{vaccineId}")
	public ResponseEntity<VaccinationResponse> getAllCitizen(@PathVariable Integer vaccineId){
		
		return ResponseEntity.status(HttpStatus.OK).body(vaccinationService.findVaccinationCenterResponse(vaccineId));
	}
}
