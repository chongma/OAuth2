package uk.me.kissy.oauth2.old;

import java.util.List;

import org.apache.cxf.rs.security.oauth2.common.AccessTokenRegistration;
import org.apache.cxf.rs.security.oauth2.common.Client;
import org.apache.cxf.rs.security.oauth2.common.OAuthPermission;
import org.apache.cxf.rs.security.oauth2.common.ServerAccessToken;
import org.apache.cxf.rs.security.oauth2.common.UserSubject;
import org.apache.cxf.rs.security.oauth2.grants.code.AuthorizationCodeDataProvider;
import org.apache.cxf.rs.security.oauth2.grants.code.AuthorizationCodeRegistration;
import org.apache.cxf.rs.security.oauth2.grants.code.ServerAuthorizationCodeGrant;
import org.apache.cxf.rs.security.oauth2.provider.OAuthServiceException;
import org.apache.cxf.rs.security.oauth2.tokens.refresh.RefreshToken;

public class CustomOAuthDataProvider implements AuthorizationCodeDataProvider {

	@Override
	public List<OAuthPermission> convertScopeToPermissions(Client arg0, List<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerAccessToken createAccessToken(AccessTokenRegistration arg0) throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerAccessToken getAccessToken(String arg0) throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerAccessToken> getAccessTokens(Client arg0, UserSubject arg1) throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClient(String arg0) throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerAccessToken getPreauthorizedToken(Client arg0, List<String> arg1, UserSubject arg2, String arg3)
			throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RefreshToken> getRefreshTokens(Client arg0, UserSubject arg1) throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerAccessToken refreshAccessToken(Client arg0, String arg1, List<String> arg2)
			throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAccessToken(ServerAccessToken arg0) throws OAuthServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void revokeToken(Client arg0, String arg1, String arg2) throws OAuthServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServerAuthorizationCodeGrant createCodeGrant(AuthorizationCodeRegistration arg0)
			throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerAuthorizationCodeGrant> getCodeGrants(Client arg0, UserSubject arg1)
			throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerAuthorizationCodeGrant removeCodeGrant(String arg0) throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
