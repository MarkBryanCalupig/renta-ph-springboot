package com.casestudy.rentaph.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * <h1>GlobalExceptionHandler!</h1> The GlobalExceptionHandler generates the
 * Response Entity of the Error to be sent to a client web-site.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * Construct a ResourceNotFoundException when called.
	 * 
	 * @param exception. use to get the message of the from the Controller class.
	 * @param request. Details of the HTTPRequest.
	 * 
	 * @return Response Entity. Contains the ErrorDetails and the HTTPStatus.
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
