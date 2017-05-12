package uk.me.kissy.oauth2.registration;

public class InvalidRegistration {
	private String message;

	public InvalidRegistration(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}