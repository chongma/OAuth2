package uk.me.kissy.oauth2.dataProviders;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.cxf.rs.security.oauth2.provider.JPAOAuthDataProvider;

public class CustomJPAOAuthDataProvider extends JPAOAuthDataProvider {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
    protected void commitIfNeeded(EntityManager em) {
        em.getTransaction().commit();
    }

	@Override
    protected void closeIfNeeded(EntityManager em) {
        em.close();
    }
}
