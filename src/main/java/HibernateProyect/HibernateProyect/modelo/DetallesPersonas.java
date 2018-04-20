package HibernateProyect.HibernateProyect.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "A_DTL")
public class DetallesPersonas {

	
	@Id
	@GeneratedValue
	@Column(name = "DTL_ID")
	private Integer idDtl;
	
	@Column(name = "DTL_HIJ", nullable = false)
	private boolean tieneHijos;
	
	@Column(name = "DTL_MAS", nullable = false)
	private boolean tieneMascotas;
	
	@Column(name = "DTL_DEP", nullable = false)
	private boolean haceDeporte;

	@OneToOne
	private Persona persona;
	
	
	public DetallesPersonas() {
	}
	
	public Persona getPersona() {
		return getPersona();
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Integer getIdDtl() {
		return idDtl;
	}


	public void setIdDtl(Integer idDtl) {
		this.idDtl = idDtl;
	}


	public boolean isTieneHijos() {
		return tieneHijos;
	}


	public void setTieneHijos(boolean tieneHijos) {
		this.tieneHijos = tieneHijos;
	}


	public boolean isTieneMascotas() {
		return tieneMascotas;
	}


	public void setTieneMascotas(boolean tieneMascotas) {
		this.tieneMascotas = tieneMascotas;
	}


	public boolean isHaceDeporte() {
		return haceDeporte;
	}


	public void setHaceDeporte(boolean haceDeporte) {
		this.haceDeporte = haceDeporte;
	}
	
	
}
