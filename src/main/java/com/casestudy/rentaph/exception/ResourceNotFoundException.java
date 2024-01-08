package com.casestudy.rentaph.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <h1>ResourceNotFoundException!</h1> The ResourceNotFoundException class sets
 * the message from the throwable message once HttpStatus.NOT_FOUND.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Construct a ResourceNotFoundException when called.
	 * 
	 * @param message. This message from the controller classes.
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}
}