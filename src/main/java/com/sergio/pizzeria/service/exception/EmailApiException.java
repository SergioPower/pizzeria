package com.sergio.pizzeria.service.exception;

public class EmailApiException extends RuntimeException {
	public EmailApiException() {
		super("Error sending email via external API");
	}
}
