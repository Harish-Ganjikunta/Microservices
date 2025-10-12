package com.vaccination.center.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CENTER_NAME")
	private String centerName;
	
	@Column(name = "CENTER_ADDRESS")
	private String centerAddress;

	@Version
	private int version;

}
