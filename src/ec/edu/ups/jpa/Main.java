package ec.edu.ups.jpa;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TipoTelefonoDAO;
import ec.edu.ups.entidad.TipoTelefono;

public class Main {

	public static void main(String[] args) {
		TipoTelefonoDAO t = DAOFactory.getFactory().getTipoTelefonoDAO();
		TipoTelefono tt = new TipoTelefono("CE");
		
		t.create(tt);
		
	}

}
