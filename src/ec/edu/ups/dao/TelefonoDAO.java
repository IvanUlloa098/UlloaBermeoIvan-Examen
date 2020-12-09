package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidad.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer> {

	List<Telefono> find_ced(String cedula);
	
	List<Telefono> find_telefono(String telefono);
	
}
