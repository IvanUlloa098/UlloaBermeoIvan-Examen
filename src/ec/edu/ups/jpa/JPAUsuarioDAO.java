package ec.edu.ups.jpa;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO {

	public JPAUsuarioDAO() {
		super(Usuario.class);
	}
	
}
