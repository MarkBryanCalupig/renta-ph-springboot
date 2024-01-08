package com.casestudy.rentaph.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.rentaph.dto.AvailabilityDTO;
import com.casestudy.rentaph.dto.PropertyDetailsDTO;
import com.casestudy.rentaph.entity.Property;
import com.casestudy.rentaph.exception.ResourceNotFoundException;
import com.casestudy.rentaph.repository.PropertyRepository;
import com.casestudy.rentaph.service.PropertyService;

/**
 * <h1>PropertyServiceImpl!</h1> The PropertyServiceImpl program implements an
 * application that will handle Request and Response of the PropertyController.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
@Service
public class PropertyServiceImpl implements PropertyService {

	/*
	 * Inherits PropertyRepository.
	 */
	@Autowired
	private PropertyRepository propertyRepository;

	/**
	 * Call to the propertyRepository to find in the database the property that
	 * contains the parameter property id.
	 * 
	 * @param id. The id that will be search to the database.
	 * @return Property, once the property with the given id has found.
	 */
	@Override
	public Optional<Property> findById(Long id) {
		return propertyRepository.findById(id);
	}

	/**
	 * Calls to the propertyRepository to add the propertyDetails in the database.
	 * 
	 * @param propertyDetails. The property that will be push to the database.
	 * @return newProperty once the id is added successfully, null if unsuccessful.
	 * @throws ResourceNotFoundException
	 */
	@Override
	public Property addProperty(Property propertyDetails) throws ResourceNotFoundException {
		Property newProperty = propertyRepository.save(propertyDetails);
		if (newProperty != null) {
			return newProperty;
		} else {
			throw new ResourceNotFoundException("Cannot Add Property");
		}
	}

	/**
	 * Calls to the propertyRepository to update the propertyDetails in the
	 * database.
	 * 
	 * @param propertyDetails. The property that will be updated to the database.
	 * @return property once the property is updated successfully, null if property
	 *         was not found.
	 * @throws ResourceNotFoundException
	 */
	@Override
	public Property updateProperty(Property propertyDetails) throws ResourceNotFoundException {
		Optional<Property> propertyData = propertyRepository.findById(propertyDetails.getId());

		if (propertyData.isPresent()) {
			Property property = propertyData.get();
			property.setLandlord(propertyDetails.getLandlord());
			property.setImageUrl(propertyDetails.getImageUrl());
			property.setPropertyName(propertyDetails.getPropertyName());
			property.setPropertyAddress(propertyDetails.getPropertyAddress());
			property.setPropertyType(propertyDetails.getPropertyType());
			property.setAreaInFeet(propertyDetails.getAreaInFeet());
			property.setBedCapacity(propertyDetails.getBedCapacity());
			property.setPrice(propertyDetails.getPrice());
			property.setAvailability(propertyDetails.getAvailability());
			property.setDescription(propertyDetails.getDescription());
			return propertyRepository.save(property);
		} else {
			throw new ResourceNotFoundException("Cannot Update Property, id not found - " + propertyDetails.getId());
		}
	}

	/**
	 * This will call to the propertyRepository to delete the property with the
	 * given in the database.
	 */
	/**
	 * Calls to propertyRepository to delete the property with the given in the
	 * database.
	 * 
	 * @param id This is the id of the property to delete.
	 * @return nothing.
	 * @throws ResourceNotFoundException
	 */
	@Override
	public void deleteProperty(Long id) throws ResourceNotFoundException {
		Optional<Property> propertyData = propertyRepository.findById(id);
		if (propertyData.isPresent()) {
			propertyRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Cannot Delete Property, id not found - " + id);
		}
	}

//	@Override
//	public List<Property> findByAvailability() {
//		return (List<Property>) propertyRepository.findAll().stream().filter(p -> p.getAvailability().compareTo((long) 1));
//	}
//	

	@Override
	public Optional<PropertyDetailsDTO> findProperty(Long id) {
		return propertyRepository.findProperty(id);
	}

	@Override
	public List<Property> findProperty(String name) {
		return propertyRepository.findAll().stream()
				.filter(p -> p.getPropertyName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
	}

	@Override
	public Object findPropertyByLandlord(String name, Long landlordId) {
		return propertyRepository.findAll().stream().filter(p -> p.getLandlord().getId().equals(landlordId))
				.filter(p -> p.getPropertyName().toLowerCase().contains(name.toLowerCase()));
	}

	@Override
	public Property changeAvailability(AvailabilityDTO availabilityDTO) throws ResourceNotFoundException {
		Optional<Property> propertyData = propertyRepository.findById(availabilityDTO.getId());
		if (propertyData.isPresent()) {
		Property property = propertyData.get();
		
		System.out.println("availability "+availabilityDTO.getAvailability());
		
		property.setAvailability(availabilityDTO.getAvailability());			
		return propertyRepository.save(property);
		} else {
		throw new ResourceNotFoundException("Cannot Update Property, id not found - " + availabilityDTO.getId());
		}	
	}


}
