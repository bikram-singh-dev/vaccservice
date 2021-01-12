package com.vaccnow.vaccservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VaccineDTO {

	private int id;
	private String name;
	private String desc;
	private int reqDoses;
	private long availableNo;	
	
}
