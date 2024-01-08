package com.casestudy.rentaph.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PropertyDetailsDTO {

	private Long id;
	private String imageUrl;
	private String propertyName;
	private String propertyAddress;
	private String propertyType;
	private int areaInFeet;
	private int bedCapacity;
	private float price;
	private Long availability;
	private String description;
	private String name;
	private String mobileNumber;
	private String email;

//	id,imageUrl,propertyName,propertyAddress,propertyType,areaInFeet,bedCapacity,price,availability,description,name,mobileNumber,email
}
