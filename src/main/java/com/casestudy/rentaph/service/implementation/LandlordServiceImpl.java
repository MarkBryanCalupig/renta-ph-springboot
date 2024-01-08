package com.casestudy.rentaph.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.rentaph.dto.LandlordStatistics;
import com.casestudy.rentaph.entity.Landlord;
import com.casestudy.rentaph.repository.LandlordRepository;
import com.casestudy.rentaph.repository.PropertyRepository;
import com.casestudy.rentaph.service.LandlordService;

/**
 * <h1>LandlordServiceImpl!</h1> The LandlordServiceImpl program implements an application that
 * will handle Request and Response of the LandlordController.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
@Service
public class LandlordServiceImpl implements LandlordService {
	@Autowired
	private LandlordRepository landlordRepository;
	@Autowired
	private PropertyRepository propertyRepository;
	
	/**
	 * This will call to the LandlordRepository find all the landlords in the database.
	 */
	@Override
	public List<Landlord> findAllLandlords(){
		return landlordRepository.findAll();
	}

	public Double getMonthlyIncome(Long id) {
		return landlordRepository.getMonthlyIncome(id);
	}
	
	public Optional<Landlord> getById(Long id){
		return landlordRepository.findById(id);
	}

	@Override
	public Optional<LandlordStatistics> getStatistics(Long id) {
		
		
////	This calls to repo to get total numbers in use of JPQL 
//		long totalProperties = landlordRepository.getTotalProperties(id);
//		long totalAvailable = landlordRepository.getTotalAvailable(id);
			
		
//		This get total numbers in use of Lambda. 
		long totalProperties = propertyRepository.findAll().stream()
				.filter(p->p.getLandlord().getId().equals(id))
				.count();
		
		long totalAvailable = propertyRepository.findAll().stream()
				.filter(p->p.getLandlord().getId().equals(id))
				.filter(p->p.getAvailability().equals(1L))
				.count();

		
		LandlordStatistics landlordStatistics = new LandlordStatistics();
		landlordStatistics.setMontlyIncome(landlordRepository.getMonthlyIncome(id));
		landlordStatistics.setTotalProperties(totalProperties);
		landlordStatistics.setTotalAvailable(totalAvailable);
		landlordStatistics.setTotalUnavailable(totalProperties-totalAvailable);
		
		return Optional.of(landlordStatistics);
	}

}
