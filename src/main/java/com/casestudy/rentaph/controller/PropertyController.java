package com.casestudy.rentaph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.rentaph.dto.AvailabilityDTO;
import com.casestudy.rentaph.entity.Property;
import com.casestudy.rentaph.exception.ResourceNotFoundException;
import com.casestudy.rentaph.service.PropertyService;

/**
 * <h1>Property Controller!</h1> The PropertyController program implements an application that
 * will handle Request and Response from a HTTP Clients.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/properties")
public class PropertyController {

	/*
	 * Inherits PropertyService.
	 */
	@Autowired
	private PropertyService propertyService;

	/**
	 * Calls to propertyService to add the given parameters to Property.
	 * 
	 * @param propertyDetails. The property that will be push to the database.
	 * @return updated property, HttpStatus.OK once the id is updated successfully.
	 * @exception ResourceNotFoundException When id not found.
	 * @see ResourceNotFoundException
	 */
	@PostMapping("/add")
	public ResponseEntity<Property> addProperty(@RequestBody Property propertyDetails) {
		Property newProperty = null;
		try {
			newProperty = propertyService.addProperty(propertyDetails);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(newProperty, HttpStatus.CREATED);
	}

	/**
	 * Calls to propertyService to update the given parameters to Property.
	 * 
	 * @param propertyDetails The property that will be push to the database.
	 * @return updated property, HttpStatus.OK once the id is updated successfully.
	 * @exception ResourceNotFoundException When id not found.
	 * @see ResourceNotFoundException
	 */
	@PutMapping("/update")
	public ResponseEntity<Property> updateProperty(@RequestBody Property propertyDetails){
		Property updatedProperty = null;
		try {
			updatedProperty = propertyService.updateProperty(propertyDetails);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(updatedProperty, HttpStatus.OK);

	}

	/**
	 * Calls to propertyService to delete the given id from Property.
	 * 
	 * @param id This is the id of the property the Front End trying to delete.
	 * @return HttpStatus.OK once the id is deleted.
	 * @exception ResourceNotFoundException When id not found.
	 * @see ResourceNotFoundException
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProperty(@PathVariable("id") Long id) throws ResourceNotFoundException {
		try {
			propertyService.deleteProperty(id);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/details/{id}")
	public ResponseEntity<?> findPropertyById(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return new ResponseEntity<>(propertyService.findProperty(id), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?> findProperty(@PathVariable("name") String name) throws ResourceNotFoundException {
		return new ResponseEntity<>(propertyService.findProperty(name), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{name}/landlord/{landlordId}")
	public ResponseEntity<?> findPropertyByLandlord(@PathVariable("name") String name, @PathVariable("landlordId") Long landlordId) throws ResourceNotFoundException {
		return new ResponseEntity<>(propertyService.findPropertyByLandlord(name, landlordId), new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping("/changeAvailability")
	public ResponseEntity<?> changeAvailability(@RequestBody AvailabilityDTO availability ) throws ResourceNotFoundException{
		return new ResponseEntity<>(propertyService.changeAvailability(availability), new HttpHeaders(), HttpStatus.OK);
	}
}
