package com.vaccination.center.models;

import java.util.List;

import com.vaccination.center.entities.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationResponse {
	
	private VaccinationCenter  vaccinationCenter;
	
	private List<Citizen>  citizens;

}
