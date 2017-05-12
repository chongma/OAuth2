package uk.me.kissy.oauth2.rs;

import static java.util.Arrays.asList;
import static org.apache.cxf.rs.security.oauth2.common.AuthenticationMethod.PASSWORD;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.catalina.realm.GenericPrincipal;
import org.apache.cxf.interceptor.security.AuthenticationException;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.rs.security.oauth2.common.UserSubject;
import org.apache.cxf.rs.security.oauth2.grants.owner.ResourceOwnerGrantHandler;
import org.apache.cxf.rs.security.oauth2.grants.owner.ResourceOwnerLoginHandler;
import org.apache.cxf.rs.security.oauth2.grants.refresh.RefreshTokenGrantHandler;
import org.apache.cxf.rs.security.oauth2.services.AccessTokenService;

import uk.me.kissy.oauth2.dataProviders.CustomJPAOAuthDataProvider;

@Path("token")
@RequestScoped
public class TokenResource {
	private final AccessTokenService delegate = new AccessTokenService();

	@Inject
	private CustomJPAOAuthDataProvider dataProvider;

	@Inject
	private HttpServletRequest request;

	@PostConstruct
	private void setup() {
		delegate.setDataProvider(dataProvider);
		Stream.of(new ResourceOwnerGrantHandler() {
			{
				setDataProvider(dataProvider);
				final ResourceOwnerLoginHandler loginHandler = (name, password) -> {
					try {
						request.login(name, password);
						try {
							final Principal pcp = request.getUserPrincipal();
							final List<String> roles = GenericPrincipal.class.isInstance(pcp)
									? new ArrayList<String>(asList(GenericPrincipal.class.cast(pcp).getRoles()))
									: Collections.<String>emptyList();
							final UserSubject userSubject = new UserSubject(name, roles);
							userSubject.setAuthenticationMethod(PASSWORD);
							return userSubject;
						} finally {
							request.logout();
						}
					} catch (final ServletException e) {
						throw new AuthenticationException(e.getMessage());
					}
				};
				setLoginHandler(loginHandler);
			}
		}, new RefreshTokenGrantHandler() {
			{
				setDataProvider(dataProvider);
			}
		}).forEach(delegate::setGrantHandler);
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response handleTokenRequest(final MultivaluedMap<String, String> params) {
		return delegate.handleTokenRequest(params);
	}

	@Context
	public void setMessageContext(final MessageContext context) {
		delegate.setMessageContext(context);
	}
}
