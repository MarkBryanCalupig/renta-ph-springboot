package com.casestudy.rentaph.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.casestudy.rentaph.entity.Landlord;
import com.casestudy.rentaph.entity.Property;
import com.casestudy.rentaph.exception.ResourceNotFoundException;
import com.casestudy.rentaph.service.implementation.PropertyServiceImpl;
import com.casestudy.rentaph.repository.PropertyRepository;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTests {

	@Mock
	private PropertyRepository propertyRepository;
	
	@InjectMocks
	private PropertyServiceImpl propertyService;
	
	Landlord landlord = new Landlord();
	Long id;
	Optional<Property> foundProperty;
	Property property;
	Property returnProperty;

	@BeforeEach
	public void setup() {

		landlord.setId(1L);
		property = new Property(1L, landlord, "assets\\img\\property-1.jpg", "Charles Place", "Paranaque City", "House",
				30, 2, 3500, 1L, "Very nice place to live");
	}
	
   	@DisplayName("JUnit test for findById method")
	@Test
	public void givenId_whenfindById_thenReturnPropertyObject() {
		// given- pre condition or setup
	   given(propertyRepository.findById(1L)).willReturn(Optional.of(property));

		// when - action or the behaviour that we are going test
		Optional<Property> foundProperty = propertyService.findById(1L);

		// then - verify the output
		assertNotNull(foundProperty);

   }
	   
//	   @DisplayName("JUnit test for findById method (negative senario)")
//	    @Test
//	    public void givenId_whenfindById_thenReturnNull() throws ResourceNotFoundException {
//			// given- pre condition or setup	        
//		   given(propertyRepository.findById(2L)).willReturn(Optional.of(property));
//
//			// when - action or the behaviour that we are going test
//	        Optional<Property> foundProperty = propertyService.findById(null);
//	        when(propertyService.findById(any())).thenThrow(Exception.class);
//
//			// then - verify the output
//	        assertNull(foundProperty);
//
//	   }
	
//	@DisplayName("JUnit Test for addProperty Method")
//	@Test
//	public void givenPropertyObject_whenAddProperty_thenReturnPropertyObject() {
//
//		// given- pre condition or setup
//		given(propertyRepository.save(property)).willReturn(property);
//		given(propertyRepository.findById(property.getId())).willReturn(Optional.of(property));
//
//		System.out.println(property);
//		
//		// when - action or the behaviour that we are going test
//		propertyService.addProperty(property);
//		
//		System.out.println();
//		// then - verify the output
//		assertNotNull(property);
//	}
	
	@DisplayName("JUnit Test for addProperty Method")
	@Test
	public void givenPropertyObject_whenAddProperty_thenReturnPropertyObject() throws ResourceNotFoundException {

		// given- pre condition or setup
		given(propertyRepository.save(property)).willReturn(property);
		
		// when - action or the behaviour that we are going test
		Optional<Property> addedProperty = Optional.ofNullable(propertyService.addProperty(property));
		
		// then - verify the output
		assertNotNull(addedProperty);
	}


	@DisplayName("JUnit Test for addProperty Method (negative senario)")
	@Test
	public void givenPropertyObject_whenAddProperty_thenReturnNull() throws ResourceNotFoundException {

		// given- pre condition or setup
		given(propertyRepository.save(property)).willReturn(null);

		// when - action or the behaviour that we are going test
//		Property addedProperty = propertyService.addProperty(property);
//
//		// then - verify the output
//		assertNull(addedProperty);;
	}
	
	@DisplayName("JUnit test for updateProperty method")
    @Test
    public void givenEmployeeObject_whenUpdateProperty_thenReturnUpdatedProperty(){
        
		// given- pre condition or setup
        given(propertyRepository.save(property)).willReturn(property);
        
        property.setDescription("sample only");
        property.setPrice(1200);
        
		// when - action or the behaviour that we are going test
        Property updatedProperty = propertyRepository.save(property);
        
		// then - verify the output
        assertThat(updatedProperty.getDescription()).isEqualTo("sample only");
        assertThat(updatedProperty.getPrice()).isEqualTo(1200);
        
    }
	
    @DisplayName("JUnit test for deleteExpense method")
    @Test
    public void givenExpenseObject_whenDeleteExpense_thenNothing() throws ResourceNotFoundException {
       
        Long propertyId = property.getId();
        
		// given- pre condition or setup
		given(propertyRepository.findById(propertyId)).willReturn(Optional.of(property));

		// when - action or the behaviour that we are going test
        propertyService.deleteProperty(property.getId());

		// then - verify the output
        verify(propertyRepository).deleteById(propertyId);
    }
	
}
