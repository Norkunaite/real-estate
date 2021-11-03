package tech.norkunaite.estate.exceptions;

import java.io.IOException;

public class PasswordMatchException extends IOException {

	public PasswordMatchException() {
		super();
	}

	public PasswordMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordMatchException(String message) {
		super(message);
	}

	public PasswordMatchException(Throwable cause) {
		super(cause);
	}
	
	

}
