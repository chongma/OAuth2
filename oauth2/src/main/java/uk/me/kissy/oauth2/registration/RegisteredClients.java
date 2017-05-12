package uk.me.kissy.oauth2.registration;

import java.util.Collection;

import org.apache.cxf.rs.security.oauth2.common.Client;

public class RegisteredClients {
	private Collection<Client> clients;

	public RegisteredClients(Collection<Client> clients) {
		this.clients = clients;
	}

	public Collection<Client> getClients() {
		return clients;
	}

}
