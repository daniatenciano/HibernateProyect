package es.aytos.hibernate.hibernate.pruebas;


import java.util.*;
import java.util.List;
import HibernateProyect.HibernateProyect.modelo.*;
import es.aytos.hibernate.hibernate.repositorio.*;

public class PruebasPersonas {

	public static void main(String[] args) {
		
		final Integer idPersona = crearPersona("123456789L", "jaa");
//		modificarPersona("Daniel", "jaa");
		eliminarPersona(idPersona); 
//		 crearPersona();

	}



	private static Integer crearPersona(String dni, String login) {

		final Persona persona = new Persona();

		persona.setNombre("Daniel");
		persona.setApellidos("Atenciano Rodríguez");
		persona.setEdad(18);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("jaa");

		
		final Direccion direccion1 = new Direccion();
		direccion1.setCiudad("Ecija");
		direccion1.setProvincia("Sevilla");
		direccion1.setCodigoPostal("41400");
		direccion1.setCalle("calle AguaBajo");
		direccion1.setBloque(1);
		direccion1.setPlanta(3);
		direccion1.setPersonas(Arrays.asList(persona));
		
		
		final Direccion direccion2 = new Direccion();
		direccion2.setCiudad("Cañada Rosal");
		direccion2.setProvincia("Sevilla");
		direccion2.setCodigoPostal("41300");
		direccion2.setCalle("calle campo");
		direccion2.setBloque(3);
		direccion2.setPlanta(2);
		direccion2.setPersonas(Arrays.asList(persona));
		
		
		return RepositorioPersona.CrearPersona(persona);
	}
	
	 


	private static void modificarPersona(Integer idPersona) {

		final Persona persona = new Persona();

		persona.setNombre("Daniel2");
		persona.setApellidos("rodriguez atenciano");
		persona.setEdad(78);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni("25143678V");
		persona.setIdUsuario(idPersona);

		
		RepositorioPersona.modificarPersona(persona);
	}
 
	
	private static void eliminarPersona(final Integer idPersona) {

		final Persona persona = new Persona();
		
		persona.setNombre("Daniel2");
		persona.setApellidos("rodriguez atenciano");
		persona.setEdad(78);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni("25143678V");
		
//		persona.setIdPersona(1);

		RepositorioPersona.eliminarPersona(idPersona);
	}
	
	
//	 private static Integer crearCoche() {
//			
//		 final Coche coche = new Coche();
//		
//		 coche.setIdCoche(1);
//		 coche.setMarca("Audi");
//		 coche.setModelo("A7");
//		 coche.setColor("Azul Electrico");
//		 coche.setMatricula("1045JKL");
//		 coche.setTipo("Berlina");
//		 coche.setEstadoCoche(EstadoCoche.NUEVO);
//		
//		 return RepositorioCoche.CrearCoche(coche);
//		
//		 }


	 
	  
	 public static void consultarPersona(final Integer idPersona) {
		 final Persona persona = RepositorioPersona.consultarNombreCompleto(idPersona);
		 
//		 System.out.println(persona.getIdPersona());
		 System.out.println(persona.getNombre());
		 System.out.println(persona.getApellidos());
		 System.out.println(persona.getEstadoCivil());
		 System.out.println(persona.getEdad());
		 System.out.println(persona.getDni());
	 }
	  
	 
	 private static void consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,String login) {
		
		 final List<Persona> personas =  RepositorioPersona.consultar(nombre,apellidos,dni,estadoCivil,login);
		 
		 System.out.println(personas.size());
	 
	 }
}
