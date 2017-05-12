package uk.me.kissy.oauth2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
public class TokenEntity {
	@Id
	private String id;

	@ManyToOne
	private ClientEntity client;

	private String tokenType;
	private String refreshToken;
	private long expiresIn;
	private long issuedAt;
	private String issuer;
	private String grantType;
	private String clientCodeVerifier;
	private String nonce;
	private String responseType;
	private String grantCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public long getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(long issuedAt) {
		this.issuedAt = issuedAt;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getClientCodeVerifier() {
		return clientCodeVerifier;
	}

	public void setClientCodeVerifier(String clientCodeVerifier) {
		this.clientCodeVerifier = clientCodeVerifier;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getGrantCode() {
		return grantCode;
	}

	public void setGrantCode(String grantCode) {
		this.grantCode = grantCode;
	}

}