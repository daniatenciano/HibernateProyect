package es.aytos.hibernate.hibernate.pruebas;


import java.util.*;
import java.util.List;
import HibernateProyect.HibernateProyect.modelo.*;
import es.aytos.hibernate.hibernate.repositorio.*;

public class PruebasPersonas {

	public static void main(String[] args) {
		
		final Integer idPersona = crearPersona("12345688L", "jaa34");
        // eliminarPersona(idPersona);
        // modificarPersona(idPersona);
        consultarPersona(idPersona);
        // consultarPersona("", "", "", null, "login_modificado");
		
		 
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
		persona.setPassword("12345");
		persona.setGenero(null);
		
		Direccion direccion1 = new Direccion();
		direccion1.setProvincia("Sevilla");
		direccion1.setCodigoPostal("41400");
		direccion1.setCiudad("Ecija");
		direccion1.setCalle("Calle Luz");
		direccion1.setNumero(1);
		direccion1.setPersonas(Arrays.asList(persona));
		
		DetallesPersonas detalle1 = new DetallesPersonas();
		detalle1.setHaceDeporte(true);
		detalle1.setTieneHijos(false);
		detalle1.setTieneMascotas(false);
//		persona.setDetalles(detalle1);
		detalle1.setPersona(persona);
		Direccion direccion2 = new Direccion();
		direccion2.setProvincia("Sevilla");
		direccion2.setCodigoPostal("41400");
		direccion2.setCiudad("Ecija");
		direccion2.setCalle("Calle Sol");
		direccion2.setNumero(2);
		direccion2.setPersonas(Arrays.asList(persona));
		
		Telefono telefono1 = new Telefono();
		telefono1.setTelefono("695035024");
		Telefono telefono2 = new Telefono();
		telefono2.setTelefono("674639246");
//		persona.addPhone( telefono1 );
//		persona.addPhone(telefono2);
		
		final Telefono telefono = new Telefono();
        telefono.setTelefono("954837770");
        telefono.setPersona(persona);

        persona.setDirecciones(Arrays.asList(direccion1, direccion2));
        persona.setTelefonos(new HashSet<>(Arrays.asList(telefono)));

	
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
		persona.setFechaAlta(new Date());

		
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
	
	



	 
	  
	 public static void consultarPersona(final Integer idPersona) {
		 final Persona persona = RepositorioPersona.consultarNombreCompleto(idPersona);
		 
//		 System.out.println(persona.getIdPersona());
		 System.out.println(persona.getNombre());
		 System.out.println(persona.getApellidos());
		 System.out.println(persona.getEstadoCivil());
		 System.out.println(persona.getEdad());
		 System.out.println(persona.getDni());
		 
//		 persona.getTelefono().forEach(telefono -> System.out.println(telefono.getTelefono()));
		 
	 }
	  
	 
	 private static void consultarPersona(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,String login) {
		
		 final List<Persona> personas =  RepositorioPersona.consultar(nombre,apellidos,dni,estadoCivil,login);
		 
		 System.out.println(personas.size());
	 
	 }

		private static void agregarDireccion(Persona persona) {
			final Direccion direccion = new Direccion();
			direccion.setProvincia("Sevilla");
			direccion.setCiudad("Ecija");
			direccion.setCodigoPostal("41400");
			direccion.setCalle("Aguabajo");
			direccion.setNumero(8);
			direccion.setBloque(3);
			direccion.setPlanta(2);
			direccion.setPuerta("E");
			
			persona.addDireccion(direccion);
		}
		
		private static void agregarTelefono(Persona persona) {
			final Telefono telefono = new Telefono();
			telefono.setNumero("695035304");
			final Telefono telefono2 = new Telefono();
			telefono2.setNumero("974558967");
			persona.addTelefono(telefono);
			persona.addTelefono(telefono2);
		}
}
