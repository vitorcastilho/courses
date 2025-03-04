package com.course.infrastructure.Exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String developerMessage;
	private final String clientMessage;

	public ResourceNotFoundException(String developerMessage, String clientMessage) {
		super(developerMessage);
		this.developerMessage = developerMessage;
		this.clientMessage = clientMessage;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public String getClientMessage() {
		return clientMessage;
	}
}
