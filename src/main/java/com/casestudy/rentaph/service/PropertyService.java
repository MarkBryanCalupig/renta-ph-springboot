package com.casestudy.rentaph.service;

import java.util.List;
import java.util.Optional;

import com.casestudy.rentaph.dto.AvailabilityDTO;
import com.casestudy.rentaph.dto.PropertyDetailsDTO;
import com.casestudy.rentaph.entity.Property;
import com.casestudy.rentaph.exception.ResourceNotFoundException;

/**
 * <h1>PropertyService!</h1> The PropertyService is the abstraction of methods in the PropertyServiceImpl.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
public interface PropertyService {

	/**
	 * This is to have an abstraction when calling the propertyRepository to add the property in the database.
	 * @throws ResourceNotFoundException 
	 */
	Property addProperty(Property property) throws ResourceNotFoundException;

	/**
	 * This is to have an abstraction when calling the propertyRepository to update the property in the database.
	 */
	Property updateProperty(Property propertyDetails) throws ResourceNotFoundException;

	/**
	 * This is to have an abstraction when calling the propertyRepository to delete the property in the database.
	 */
	void deleteProperty(Long id) throws ResourceNotFoundException;

	/**
	 * This is to have an abstraction when calling the propertyRepository to find the property with the given id in the database.
	 */
	Optional<Property> findById(Long id);
	
	
	Optional<PropertyDetailsDTO> findProperty(Long id);

	List<Property> findProperty(String name);


	Object findPropertyByLandlord(String name, Long landlordId);

	Property changeAvailability(AvailabilityDTO availability) throws ResourceNotFoundException;

}