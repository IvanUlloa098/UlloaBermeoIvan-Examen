package ec.edu.ups.dao;

import ec.edu.ups.jpa.JPADAOFactory;

/**
 * Clase DAOFactory.
 * 
 * La clase abstracta DAOFcatory implementa el patrón de diseño Factory el cuál
 * busca tener una jerarquía de clases para su control e implementación de
 * manera organizada. En este ejemplo la clase DAOFactory declara los métodos
 * que serán implementados en la clase que podra gestionar el acceso y creación
 * de todos los DAOs específicos.
 * 
 * 
 * Doctor en Tecnologías de Información.
 * https://www.linkedin.com/in/gabrielleonp
 * 
 * @see https://www.arquitecturajava.com/usando-el-patron-factory/
 * @see JDBCCategoriaDAO
 * @version 1.0
 */
public abstract class DAOFactory {
	protected static DAOFactory factory = new JPADAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
	}

	public abstract void createTables();

	public abstract TipoTelefonoDAO getTipoTelefonoDAO();

	public abstract TelefonoDAO getTelefonoDAO();

	public abstract UsuarioDAO getUsuarioDAO();

}
