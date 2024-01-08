package com.casestudy.rentaph.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.rentaph.entity.Landlord;
import com.casestudy.rentaph.exception.ResourceNotFoundException;
import com.casestudy.rentaph.service.LandlordService;

/**
 * <h1>Landlord Controller!</h1> The LandlordController program implements an application that
 * will handle Request and Response from a HTTP Clients.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/landlords")
public class LandlordController {

	/*
	 * Inherits LandlordService.
	 */
	private final LandlordService landlordService;

	/**
	 * Initiates landlordService. This gives the whole class to call any methods in
	 * LandlordService.class
	 */
	public LandlordController(LandlordService landlordService) {
		this.landlordService = landlordService;
	}

	/**
	 * Calls to landlordService to provide this the list of Landlords.
	 * 
	 * @return updated property, HttpStatus.OK once the id is updated successfully.
	 */
	@GetMapping
	public ResponseEntity<List<Landlord>> getAllLandlords() {
		List<Landlord> landlords = landlordService.findAllLandlords();
		return new ResponseEntity<>(landlords, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getLandlord(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return new ResponseEntity<>(landlordService.getById(id), new HttpHeaders(), HttpStatus.OK);
	}
	
	
	// gets the landlord statistics.
	@GetMapping("/{id}/statistics")
	public ResponseEntity<?> getStatistics(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return new ResponseEntity<>(landlordService.getStatistics(id), new HttpHeaders(), HttpStatus.OK);
	}	
	
	
}
