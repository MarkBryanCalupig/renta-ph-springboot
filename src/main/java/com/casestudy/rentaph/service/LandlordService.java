package com.casestudy.rentaph.service;

import java.util.List;
import java.util.Optional;

import com.casestudy.rentaph.dto.LandlordStatistics;
import com.casestudy.rentaph.entity.Landlord;

/**
 * <h1>LandlordService!</h1> The LandlordService is the abstraction of methods in the LandlordServiceImpl.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
public interface LandlordService {
	/**
	 * This is to have an abstraction when calling the landlordRepository to find all the landlord in the database.
	 */
	List<Landlord> findAllLandlords();

	Optional<Landlord> getById(Long id);
	
	Optional<LandlordStatistics> getStatistics(Long id);

	// total available, unavailable, count of properties

}