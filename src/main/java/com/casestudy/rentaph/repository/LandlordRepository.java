package com.casestudy.rentaph.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.casestudy.rentaph.entity.Landlord;

/**
 * <h1>Landlord Repository!</h1> The LandlordRepository program implements an
 * application that will transact landlords with the database.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
@RepositoryRestResource(collectionResourceRel = "landlords", path = "landlords")
public interface LandlordRepository extends JpaRepository<Landlord, Long> {

	@Query("select sum(p.price) from Landlord l join Property p on p.landlord.id=l.id where l.id=:id and p.availability=0")
	Double getMonthlyIncome(@Param("id") Long id);

	@Query("select count(p.id) from Property p join Landlord l on p.landlord.id=l.id where l.id=:id")
	Integer getTotalProperties(@Param("id") Long id);

	@Query("select count(p.id) from Property p join Landlord l  on p.landlord.id=l.id where l.id=:id and p.availability=0")
	Integer getTotalAvailable(@Param("id") Long id);

}