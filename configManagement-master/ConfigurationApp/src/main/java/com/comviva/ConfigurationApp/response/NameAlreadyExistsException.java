package com.comviva.ConfigurationApp.response;

public class NameAlreadyExistsException extends RuntimeException {
	
	
	NameAlreadyExistsException(String name) {
		
		super(String.format("UseCase with %d already exists please try again with different useCaseName ", name));
	}

}
