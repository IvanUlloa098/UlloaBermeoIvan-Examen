package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Telefono
 *
 */
@Entity

public class Telefono implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String numero;
	private String operadora;

	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "telefono")
	private TipoTelefono tipoTelefono;
	
	
	public Telefono() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getOperadora() {
		return operadora;
	}


	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public TipoTelefono getTipoTelefono() {
		return tipoTelefono;
	}


	public void setTipoTelefono(TipoTelefono tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}
	
	
   
}
