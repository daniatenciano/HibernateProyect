package HibernateProyect.HibernateProyect.modelo;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.*;
import javax.persistence.*;


@Entity(name = "Direccion")
public class Direccion {
	
	@Id
	@GeneratedValue
	private Integer idDireccion;
	
	@Column(name = "DIR_PRO",nullable = false)
	private String provincia;
	
	@Column(name = "DIR_CIU", nullable = false)
	private String ciudad;
	
	@Column(name = "DIR_CP", nullable = false)
	private String codigoPostal;
	
	@Column(name = "DIR_CAL",nullable = false)
	private String calle;
	
	@Column(name = "DIR_NUM", nullable = false)
	private Integer numero;
	
	@Column(name = "DIR_BLQ", nullable = false)
	private Integer bloque;
	
	@Column(name = "DIR_PLA", nullable = false)
	private Integer planta;
	
	@Column(name = "DIR_PUE", nullable = false)
	private String puerta;

	
	
	  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	  private List<Persona> personas = new ArrayList<>();
	
	
	public List<Persona> getDirecciones() {
		return personas;
	}

	public void setDirecciones(List<Persona> personas) {
		this.personas = personas;
	}

	@ManyToMany(mappedBy = "addresses")
    private List<Direccion> owners = new ArrayList<>();
	
	
	public List<Direccion> getOwners() {
		return owners;
	}

	public void setOwners(List<Direccion> owners) {
		this.owners = owners;
	}

	public Direccion() {
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getBloque() {
		return bloque;
	}

	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	
	 public void addDireccion(Direccion direccion) {
//		 direccion.add( direccion);
		 direccion.getOwners().add( this );
	    
	 }


	public void removeDireccion(Direccion direccion) {
//	        direccion.remove( direccion );
	        direccion.getOwners().remove( this );
	    
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	

 
}