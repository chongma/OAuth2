package uk.me.kissy.oauth2.rs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//import org.apache.cxf.rs.security.oauth2.services.AccessTokenService;
//import org.apache.cxf.rs.security.oauth2.services.AccessTokenValidatorService;

@ApplicationPath("api")
public class OAuth2Application extends Application {
	public Set<Class<?>> getClasses() {
		return new HashSet<Class<?>>(Arrays.asList(TokenResource.class, ValidateResource.class));
		// return new HashSet<Class<?>>(Arrays.asList(AccessTokenService.class,
		// AccessTokenValidatorService.class));
	}
}