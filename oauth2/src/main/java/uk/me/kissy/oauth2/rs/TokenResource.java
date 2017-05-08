package uk.me.kissy.oauth2.rs;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.rs.security.oauth2.services.AccessTokenService;

@Path("token")
@RequestScoped
public class TokenResource {
	private final AccessTokenService delegate = new AccessTokenService();

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
