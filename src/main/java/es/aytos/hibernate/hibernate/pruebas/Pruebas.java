package es.aytos.hibernate.hibernate.pruebas;

import org.hibernate.mapping.List;

import HibernateProyect.HibernateProyect.modelo.*;
import es.aytos.hibernate.hibernate.repositorio.*;

public class Pruebas {

	public static void main(String[] args) {
		
//		modificarPersona(2);
//		eliminarPersona(3);
		crearCoche();

	}



//	private static Integer crearPersona() {
//
//		final Persona persona = new Persona();
//
//		persona.setNombre("Daniel");
//		persona.setApellidos("Atenciano Rodríguez");
//		persona.setEdad(18);
//		persona.setEstadoCivil(EstadoCivil.SOLTERO);
//		persona.setDni("17477107M");
//
//		return RepositorioPersona.CrearPersona(persona);
//	}
//
//	private static void modificarPersona(int i) {
//
//		final Persona persona = new Persona();
//
//		persona.setNombre("Daniel2");
//		persona.setApellidos("rodriguez atenciano");
//		persona.setEdad(78);
//		persona.setEstadoCivil(EstadoCivil.SOLTERO);
//		persona.setDni("25143678V");
//
//		RepositorioPersona.modificarPersona(persona);
//	}

	
	
	
	 
//	private static void eliminarPersona(final Integer idPersona) {
//
//		final Persona persona = new Persona();
//		
//		persona.setNombre("Daniel2");
//		persona.setApellidos("rodriguez atenciano");
//		persona.setEdad(78);
//		persona.setEstadoCivil(EstadoCivil.SOLTERO);
//		persona.setDni("25143678V");
//		
//		persona.setIdPersona(1);
//
//		RepositorioPersona.eliminarPersona(idPersona);
//	}
	
	
	 private static Integer crearCoche() {
			
		 final Coche coche = new Coche();
		
		 coche.setIdCoche(1);
		 coche.setMarca("Audi");
		 coche.setModelo("A7");
		 coche.setColor("Azul Electrico");
		 coche.setMatricula("1045JKL");
		 coche.setTipo("Berlina");
		 coche.setEstadoCoche(EstadoCoche.NUEVO);
		
		 return RepositorioCoche.CrearCoche(coche);
		
		 }


	 
	 private static void consultarPersona(String nombre, String apellidos, Integer dni, EstadoCivil estadoCivil) {
		 final List<Persona> personas = RepositorioPersona.consultar(nombre,apellidos,dni,estadoCivil)
	 
	 }
}
