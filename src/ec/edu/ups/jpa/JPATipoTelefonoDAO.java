package ec.edu.ups.jpa;

import ec.edu.ups.dao.TipoTelefonoDAO;
import ec.edu.ups.entidad.TipoTelefono;

public class JPATipoTelefonoDAO extends JPAGenericDAO<TipoTelefono, Integer> implements TipoTelefonoDAO {

	public JPATipoTelefonoDAO() {
		super(TipoTelefono.class);
		// TODO Auto-generated constructor stub
	}

}
