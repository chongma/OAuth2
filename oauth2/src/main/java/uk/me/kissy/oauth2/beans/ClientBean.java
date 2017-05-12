package uk.me.kissy.oauth2.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.cxf.rs.security.oauth2.common.Client;

import uk.me.kissy.oauth2.dao.ClientDao;

@Named
@ViewScoped
public class ClientBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ClientDao clientDao;

	private String clientId;
	private Client client;

	public void onload() {
		update();
	}

	private void update() {
		if (getClientId() == null)
			setClient(new Client());
		else
			setClient(clientDao.selectClient(getClientId()));
	}

	public String save() {
		// if (getClientId() == null)
		clientDao.create(getClient());
		// else
		// clientDao.update(getClient());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Client Entity saved", "The Client Entity has been saved"));
		return null;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

}
