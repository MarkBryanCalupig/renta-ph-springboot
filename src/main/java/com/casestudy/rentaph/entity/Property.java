package com.casestudy.rentaph.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * <h1>Property!</h1> The Property is the entity representation of what the
 * Property table is in the database.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
@Entity
@Table(name="property")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Property {
	
	/**
	 * The id of property.
	 */
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "property_seq", allocationSize = 0)
    private Long id;

	/**
	 * The landlord of property.
	 */
    @ManyToOne
    @JoinColumn(name="landlord_id", referencedColumnName ="id")
    private Landlord landlord;
    
    /**
	 * The image of property.
	 */
    @Column(name="image_url")
    private String imageUrl;
    
    /**
	 * The name of property.
	 */
    @Column(name="property_name")
    private String propertyName;

    /**
	 * The address of property.
	 */
    @Column(name="property_address")
    private String propertyAddress;

    /**
	 * The type of property.
	 */
    @Column(name="property_type")
    private String propertyType;

    /**
	 * The area of property.
	 */
    @Column(name="area_in_feet")
    private int areaInFeet;
    
    /**
	 * The bed capacity of property.
	 */
    @Column(name="bed_capacity")
    private int bedCapacity;
    
    /**
 	 * The rent per month of property.
 	 */
    @Column(name="price")
    private float price;
    
    /**
 	 * The availability of property.
 	 */
    @Column(name="availability")
    private Long availability;
   
    /**
  	 * The description of property.
  	 */
    @Column(name="description")
    private String description;


}
