package uk.me.kissy.oauth2.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class ClientEntity {
	@Id
	private String id;
	private String secret;
	private boolean confidential;
	private String application;
	private String webUri;

//	@OneToMany
	private List<TokenEntity> token;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public boolean isConfidential() {
		return confidential;
	}

	public void setConfidential(boolean confidential) {
		this.confidential = confidential;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getWebUri() {
		return webUri;
	}

	public void setWebUri(String webUri) {
		this.webUri = webUri;
	}

	public List<TokenEntity> getToken() {
		return token;
	}

	public void setToken(List<TokenEntity> token) {
		this.token = token;
	}

}