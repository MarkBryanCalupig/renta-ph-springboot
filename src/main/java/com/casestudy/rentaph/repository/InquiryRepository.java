package com.casestudy.rentaph.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.casestudy.rentaph.entity.Inquiry;


/**
 * <h1>Inquiry Repository!</h1> The InquiryRepository program implements an application that
 * will transact inquiries with the database.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
@RepositoryRestResource(collectionResourceRel = "inquiries", path = "inquiries")
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
}