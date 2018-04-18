package es.aytos.hibernate.hibernate.pruebas;


import java.util.List;

import HibernateProyect.HibernateProyect.modelo.*;
import es.aytos.hibernate.hibernate.repositorio.*;

public class Pruebas {

	public static void main(String[] args) {
		
//		modificarPersona(2);
//		eliminarPersona(3);
		consultar("Jose", "%arq%", "", null);

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


	 
	 
	 
	 public static void consultarPersona(final Integer idPersona) {
		 final Persona persona = RepositorioPersona.consultarNombreCompleto(idPersona);
		 
		 System.out.println(persona.getIdPersona());
		 System.out.println(persona.getNombre());
		 System.out.println(persona.getApellidos());
		 System.out.println(persona.getEstadoCivil());
		 System.out.println(persona.getEdad());
		 System.out.println(persona.getDni());
	 }
	 
	 
	 
	 private static void consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		 final List<Persona> personas =  RepositorioPersona.consultar(nombre,apellidos,dni,estadoCivil);
		 
		 System.out.println(personas.size());
	 
	 }
}
