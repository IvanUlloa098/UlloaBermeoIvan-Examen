package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoTelefono
 *
 */
@Entity
@Table(name="tipo_telefono") 
public class TipoTelefono implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tipo;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "tipoTelefono")
	private Telefono telefono;

	public TipoTelefono() {
		super();
	}
	
	public TipoTelefono(String tipo) {
		this.setTipo(tipo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}
   
	
	
}
