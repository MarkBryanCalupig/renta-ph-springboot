package com.casestudy.rentaph.exception;

import java.util.Date;

/**
 * <h1>ErrorDetails!</h1> The ErrorDetails represents as error details of every
 * Exception.
 *
 * @author Mark Bryan Calupig
 * @version 1.0
 * @since 2022-08-28
 */
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

	/**
	 * Constructs ErrorDetails contains the given date and time, message, and
	 * details of the error occurred.
	 * 
	 * @param timestamp. Date and time during the error.
	 * @param message.   ErrorMessage from the controller.
	 * @param details.   Details of the Exception.
	 * @return ErrorDetails.
	 */
	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	/**
	 * Gets the date and time.
	 * 
	 * @return timestamp at the initiation.
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Gets the message from the throwable message.
	 * 
	 * @return message from the throwing of error in the Controller Classes.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the details of the error.
	 * 
	 * @return details of the exceptions.
	 */
	public String getDetails() {
		return details;
	}
}
