package com.casestudy.rentaph.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Landlord!</h1> The Landlord is the entity representation of what the
 * Landlord table is in the database.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
@Entity
@Table(name = "landlord")
@Getter
@Setter
@Data
public class Landlord {
	/**
	 * The id of landlord.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "landlord_seq", initialValue = 4, allocationSize = 1)
	private Long id;

	/**
	 * The name of landlord.
	 */
	@Column(name = "name")
	private String name;

	/**
	 * The mobile number of landlord.
	 */
	@Column(name = "mobile_number")
	private String mobileNumber;

	/**
	 * The email address of landlord.
	 */
	@Column(name = "email")
	private String email;


}
