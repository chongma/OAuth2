package uk.me.kissy.oauth2.dataProviders;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.cxf.rs.security.oauth2.provider.JPAOAuthDataProvider;

public class CustomJPAOAuthDataProvider extends JPAOAuthDataProvider {
	@PersistenceContext(name = "oauth2")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	protected EntityTransaction beginIfNeeded(EntityManager em) {
		return null;
	}

	@Override
	protected void commitIfNeeded(EntityManager em) {
	}

	@Override
	protected void closeIfNeeded(EntityManager em) {
	}
}
