package HibernateProyect.HibernateProyect.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="C_AUD")

public class Coche {
	
	@Id
	@GeneratedValue
	@Column(name ="C_ID")
	private int idCoche;

	
	@Column(name = "C_MAR",nullable = false, length = 100)
	private String marca;
	
	@Column(name = "C_MOD",nullable = false, length = 100)
	private String modelo;
	
	@Column(name = "C_COL",nullable = false, length = 150)
	private String color;
	
	@Column(name = "C_MAT", nullable = false, length = 50)
	private String matricula;
	
	@Column(name = "C_TIP", nullable = false, length = 200)
	private  String tipo;
	
	@Column(name = "C_EST",nullable = false)
	@Enumerated
	private EstadoCoche estadoCoche;
	
	
	public Coche() {
	}

	public int getIdCoche() {
		return idCoche;
	}
	
	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}

	public void setEstadoCoche(EstadoCoche estadoCoche) {
		this.estadoCoche = estadoCoche;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public EstadoCoche getEstadoCoche() {
		return estadoCoche;
	}
	
	
}
