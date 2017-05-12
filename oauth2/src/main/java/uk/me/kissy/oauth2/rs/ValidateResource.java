package uk.me.kissy.oauth2.rs;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Encoded;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.rs.security.oauth2.common.AccessTokenValidation;
import org.apache.cxf.rs.security.oauth2.services.AccessTokenValidatorService;

import uk.me.kissy.oauth2.dataProviders.CustomJPAOAuthDataProvider;

@Path("validate")
@RequestScoped
public class ValidateResource {
	private final AccessTokenValidatorService delegate = new AccessTokenValidatorService();

	@Inject
	private CustomJPAOAuthDataProvider dataProvider;

	@PostConstruct
	private void setup() {
		delegate.setDataProvider(dataProvider);
	}

	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public AccessTokenValidation getTokenValidationInfo(@Encoded MultivaluedMap<String, String> params) {
		return delegate.getTokenValidationInfo(params);
	}

	@Context
	public void setMessageContext(final MessageContext context) {
		delegate.setMessageContext(context);
	}
}
