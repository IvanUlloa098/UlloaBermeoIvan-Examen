package ec.edu.ups.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidad.Telefono;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO {

	private EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	
	public JPATelefonoDAO() {
		super(Telefono.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Telefono> find_ced(String cedula) {
		List<Telefono> list = new ArrayList<Telefono>();
		String jpql = "SELECT t FROM Telefono t INNER JOIN t.usuario u WHERE u.cedula = '"+cedula+"'";
		list = (List<Telefono>) em.createQuery(jpql, Telefono.class).getResultList();
		return list;
	}

	@Override
	public List<Telefono> find_telefono(String telefono) {
		List<Telefono> list = new ArrayList<Telefono>();
		String jpql = "SELECT t FROM Telefono t WHERE t.numero = '"+telefono+"'";
		list = (List<Telefono>) em.createQuery(jpql, Telefono.class).getResultList();
		return list;
	}
	

}
