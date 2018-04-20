package HibernateProyect.HibernateProyect.modelo;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Cacheable
@Table(name="A_AFI")
public class Aficiones {
	
	@Id
	@GeneratedValue
	private Integer idAficiones;

	@ManyToOne
	private Persona persona;
	
	
	@Column(name = "AFI_DEP", nullable = false)
	private String deportes;
	
	@Column(name = "AFI_MUS", nullable = false)
	private String musica;
	
	@Column(name = "AFI_GYM", nullable = false) 
	private String gym;
	
	@Column(name = "AFI_FOT", nullable = false)
	private String fotografia;
	
	public Aficiones() {
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Integer getIdAficiones() {
		return idAficiones;
	}

	public void setIdAficiones(Integer idAficiones) {
		this.idAficiones = idAficiones;
	}

	public String getDeportes() {
		return deportes;
	}

	public void setDeportes(String deportes) {
		this.deportes = deportes;
	}

	public String getMusica() {
		return musica;
	}

	public void setMusica(String musica) {
		this.musica = musica;
	}

	public String getGym() {
		return gym;
	}

	public void setGym(String gym) {
		this.gym = gym;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}
	
}
