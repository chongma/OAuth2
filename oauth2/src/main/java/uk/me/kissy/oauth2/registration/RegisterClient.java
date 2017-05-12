package uk.me.kissy.oauth2.registration;

import java.util.Map;

public class RegisterClient {
	private Map<String, String> homeRealms;

	public RegisterClient(Map<String, String> homeRealms) {
		this.homeRealms = homeRealms;
	}

	public Map<String, String> getHomeRealms() {
		return homeRealms;
	}

}
