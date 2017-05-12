package uk.me.kissy.oauth2.registration;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.rt.security.crypto.CryptoUtils;

public final class CSRFUtils {

	public static final String CSRF_TOKEN = "CSRF_TOKEN";

	private CSRFUtils() {
		// complete
	}

	public static String getCSRFToken(HttpServletRequest request, boolean create) {
		if (request != null && request.getSession() != null) {
			// Return an existing token first
			String savedToken = (String) request.getSession().getAttribute(CSRF_TOKEN);
			if (savedToken != null) {
				return savedToken;
			}

			// If no existing token then create a new one, save it, and return
			// it
			if (create) {
				String token = StringUtils.toHexString(CryptoUtils.generateSecureRandomBytes(16));
				request.getSession().setAttribute(CSRF_TOKEN, token);
				return token;
			}
		}

		return null;
	}
}
