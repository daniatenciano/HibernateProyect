package HibernateProyect.HibernateProyect.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.SortComparator;
import es.aytos.hibernate.hibernate.comparadores.ComparadorTelefonos;
import es.aytos.hibernate.hibernate.conversores.Conversores;

@Entity
@Table(name = "A_PER")
public class Persona extends Usuario {

	@Column(name = "PER_NOM", nullable = false, length = 50)
	private String nombre;

	@Column(name = "PER_APE", nullable = false, length = 250)
	private String apellidos;

	@Column(name = "PER_DNI", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "PER_EDA", nullable = false)
	private Integer edad;

	@Column(name = "PER_ECV", nullable = false)
	@Enumerated(value = EnumType.ORDINAL)
	private EstadoCivil estadoCivil;

	   @ManyToMany(cascade = CascadeType.ALL)
	    private List<Direccion> direcciones;

	   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "persona", fetch = FetchType.EAGER)
	   @SortComparator(ComparadorTelefonos.class)
	   private Set<Telefono> telefonos;
	
	 @OneToOne
	 @JoinColumn(name = "detalles_id")
	 private DetallesPersonas detalles;

	 @Column(name = "PER_GEN", nullable = false, length = 1)
		@Convert(converter = Conversores.class)
		private Genero genero;

	public Persona() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;

	}
	 public List<Telefono> getPhones() {
	        return (List<Telefono>) telefonos;
	    }
	 
//	 public void addPhone(Telefono phone) {
//	        telefonos.add( phone );
//	        phone.setPersona( this );
//	    }

	    public void removePhone(Telefono phone) {
	    	telefonos.remove( phone );
	        phone.setPersona( null );
	    }
	    
	    public void addDireccion(Direccion address) {
	        direcciones.add( address );
	        address.getPropietarios().add( this );
	    }

	    public void removeAddress(Direccion address) {
	    	direcciones.remove( address );
	    	address.getPropietarios().remove( this );
	    }
	
	    public DetallesPersonas getDetails() {
	        return detalles;
	    }

	    public void setDetalles(DetallesPersonas details) {
	        this.detalles = details;
	    }

		public void setGenero(Genero genero) {
			
			this.genero =genero;
		}
		

	    public Genero getGenero() {
	        return genero;
	    }

		 public void addTelefono(Telefono telefono) {
    	telefonos.add( telefono );
    	telefono.setPersona(this);
    }

		  public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

		 public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }
		 
}