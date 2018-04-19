package HibernateProyect.HibernateProyect.modelo;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="A_TLF")
public class Telefono {
	
	@Id
	@GeneratedValue
	private String idlf;
	
	@Column(name = "TLF_NUM", nullable = false)
	private String numTlf;
	
	@ManyToOne
	private Persona persona;

	public String getNumTlf() {
		return numTlf;
	}

	public void setNumTlf(String numTlf) {
		this.numTlf = numTlf;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
