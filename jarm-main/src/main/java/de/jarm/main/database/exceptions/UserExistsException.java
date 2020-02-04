package de.jarm.main.database.exceptions;

public class UserExistsException extends Exception {
	
	public UserExistsException(String text) {
		super(text);
	}
	
}
