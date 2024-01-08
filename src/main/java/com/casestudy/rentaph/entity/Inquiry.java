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
 * <h1>Inquiry!</h1> The Inquiry is the entity representation of what the
 * Inquiry table is in the database.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
@Entity
@Table(name = "inquiry")
@Getter
@Setter
@Data
public class Inquiry {

	/**
	 * The id of the inquiry.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "inquiry_seq", initialValue = 1, allocationSize = 1)
	private Long id;

	/**
	 * The landlord of the property the users have inquired.
	 */
	@Column(name = "landlord_id")
	private int landlord;

	/**
	 * The property id of the property the users have inquired.
	 */
	@Column(name = "property_id")
	private int property;

	/**
	 * The name of the user that have inquired.
	 */
	@Column(name = "name")
	private String name;

	/**
	 * The mobile number of the user that have inquired.
	 */
	@Column(name = "mobile_number")
	private int mobileNumber;

	/**
	 * The email address of the user that have inquired.
	 */
	@Column(name = "email")
	private String email;

	/**
	 * The message of the user that have inquired.
	 */
	@Column(name = "message")
	private String message;

}
