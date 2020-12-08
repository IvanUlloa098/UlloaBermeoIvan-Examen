package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cedula; 
	private String nombres;
	private String apellidos;
	private String correo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private Set<Telefono> telefonos = new java.util.HashSet<Telefono>();

	public Usuario() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Set<Telefono> getTelefonos() {
		return telefonos;
	}

	public void addTelefonos(Telefono telefono) {
		this.telefonos.add(telefono);
    }

    public void removeTelefonos(Telefono telefono) {
    	this.telefonos.remove(telefono);
    }	
	
}
