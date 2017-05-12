package uk.me.kissy.oauth2.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.cxf.rs.security.oauth2.common.Client;
import org.apache.cxf.rs.security.oauth2.common.UserSubject;

import uk.me.kissy.oauth2.dataProviders.CustomJPAOAuthDataProvider;

@ApplicationScoped
public class ClientDao {

	private static final Logger log = Logger.getLogger(ClientDao.class.getName());

	@Inject
	private CustomJPAOAuthDataProvider dataProvider;

	public List<Client> selectClients() {
		log.fine("Selecting clients");
		return dataProvider.getClients(new UserSubject("admin"));
	}

	public Client selectClient(String clientId) {
		return dataProvider.getClient(clientId);
	}

	@Transactional
	public void create(Client client) {
		client.setResourceOwnerSubject(new UserSubject("admin"));
		dataProvider.setClient(client);
	}

	// @Inject
	// private EntityManager em;
	//
	// public List<Client> selectClients() {
	// log.fine("Selecting clients");
	// List<Client> clientEntityList = em.createQuery("Select c FROM Client c",
	// Client.class).getResultList();
	// return clientEntityList;
	// }
	//
	// public Client selectClient(String clientId) {
	// Client invoice = em.createQuery("Select c FROM Client c WHERE c.id = ?1",
	// Client.class)
	// .setParameter(1, clientId).getSingleResult();
	// return invoice;
	// }
	//
	// public void create(Client clientEntity) {
	// em.persist(clientEntity);
	// }
	//
	// public void update(Client clientEntity) {
	// em.merge(clientEntity);
	// }

}
