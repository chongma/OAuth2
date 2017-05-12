package uk.me.kissy.oauth2.registration;

public class InvalidRegistrationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidRegistrationException(String message) {
		super(message);
	}
}
