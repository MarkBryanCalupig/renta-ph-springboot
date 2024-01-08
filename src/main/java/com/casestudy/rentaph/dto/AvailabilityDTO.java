package com.casestudy.rentaph.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AvailabilityDTO {
	private Long id;
	private Long availability;
}
