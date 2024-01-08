package com.casestudy.rentaph.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.casestudy.rentaph.dto.PropertyDetailsDTO;
import com.casestudy.rentaph.entity.Property;

/**
 * <h1>LandlordRepository!</h1> The LandlordRepository program implements an
 * application that will transact properties with the database.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
@RepositoryRestResource(collectionResourceRel = "properties", path = "properties")
public interface PropertyRepository extends JpaRepository<Property, Long> {

	/**
	 * Calls to database to delete the given id from Property.
	 * 
	 * @param id This is the id of the property the Front End trying to delete.
	 * @return nothing.
	 */
	void deleteById(Long id);

	/**
	 * Calls to database to find property that are available from Property.
	 * 
	 * @param availability. This is the availability of the property. 1 if
	 *                      available, 0 if not.
	 * @param pageable.     Settings of the return property with a pagination.
	 * @return Property.
	 */
	Page<Property> findByAvailabilityOrderByPropertyNameAsc(@Param("availability") Long availability, Pageable pageable);

	/**
	 * Calls to database to find property by the landlord id from Property.
	 * 
	 * @param id.       This is the id of the landlord.
	 * @param pageable. Settings of the return property with a pagination.
	 * @return Property with the given landlord id.
	 */
	Page<Property> findByLandlordIdOrderByPropertyNameAsc(@Param("id") Long id, Pageable pageable);

	/**
	 * Calls to database to find property that contains the parameter name from
	 * Property.
	 * 
	 * @param name.     This is the name of the property trying to be search.
	 * @param pageable. Settings of the return property with a pagination.
	 * @return Property that have the propertyName like one in the parameter.
	 */
	Page<Property> findByAvailabilityAndPropertyNameContainingIgnoreCaseOrderByPropertyNameAsc(@Param("availability") Long availability, @Param("name") String name, Pageable pageable);

	/**
	 * Calls to database to find property by the landlord id and contains the
	 * parameter name from Property.
	 * 
	 * @param id.       This is the id of the landlord.
	 * @param name.     This is the name of the property trying to be search.
	 * @param pageable. Settings of the return property with a pagination.
	 * @return Property with the given landlord id and has the parameter name with
	 *         it.
	 */
	Page<Property> findByLandlordIdAndPropertyNameContainingIgnoreCaseOrderByPropertyNameAsc(@Param("id") Long id, @Param("name") String name,
			Pageable pageable);

	
	
	@Query("select new com.casestudy.rentaph.dto.PropertyDetailsDTO(p.id, p.imageUrl, p.propertyName, p.propertyAddress,"
			+ "p.propertyType, p.areaInFeet, p.bedCapacity, p.price, p.availability, p.description, l.name, l.mobileNumber, l.email) "
			+ "from Property p join Landlord l on p.landlord.id = l.id where p.id = :id")
	Optional<PropertyDetailsDTO> findProperty(@Param("id") Long id);

}
