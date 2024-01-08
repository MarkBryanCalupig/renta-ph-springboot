package com.casestudy.rentaph.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LandlordStatistics {
	
	private Double montlyIncome;
	private Long totalProperties;
	private Long totalAvailable;
	private Long totalUnavailable;
	
}
