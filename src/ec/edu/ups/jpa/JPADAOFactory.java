package ec.edu.ups.jpa;

import ec.edu.ups.dao.TipoTelefonoDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public void createTables() {
		this.getTelefonoDAO().createTable();
		this.getUsuarioDAO().createTable();
		this.getTipoTelefonoDAO().createTable();

	}

	@Override
	public TelefonoDAO getTelefonoDAO() {
		return new JPATelefonoDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JPAUsuarioDAO();
	}

	@Override
	public TipoTelefonoDAO getTipoTelefonoDAO() {
		return new JPATipoTelefonoDAO();
	}
	
}
