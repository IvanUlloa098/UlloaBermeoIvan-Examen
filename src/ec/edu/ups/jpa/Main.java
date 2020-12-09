package ec.edu.ups.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TipoTelefonoDAO;
import ec.edu.ups.entidad.TipoTelefono;
import ec.edu.ups.entidad.Usuario;

public class Main {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		TipoTelefonoDAO tipDAO = DAOFactory.getFactory().getTipoTelefonoDAO();
		TipoTelefono tt = new TipoTelefono("CELULAR");
		
		tipDAO.create(tt);
		
	}

}
