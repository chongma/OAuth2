package uk.me.kissy.oauth2.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.cxf.rs.security.oauth2.common.Client;

import uk.me.kissy.oauth2.dao.ClientDao;

@Named
@ViewScoped
public class ClientsBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ClientDao clientDao;

	private List<Client> clientList;

	public void onload() {
		update();
	}

	private void update() {
		setClientList(clientDao.selectClients());
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

}
