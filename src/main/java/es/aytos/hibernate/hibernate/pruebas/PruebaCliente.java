package es.aytos.hibernate.hibernate.pruebas;


import java.util.*;
import java.util.List;
import HibernateProyect.HibernateProyect.modelo.*;
import es.aytos.hibernate.hibernate.repositorio.*;

public class PruebaCliente {

	public static void main(String[] args) {
		
		final Integer idCliente = crearCliente("123456789L", "jaa");
		modificarCliente(idCliente);


	}


	private static Integer crearCliente(String dni, String login) {

		final Cliente cliente = new Cliente();

		cliente.setNombre("Daniel");
		cliente.setApellidos("Atenciano Rodríguez");
		cliente.setEdad(18);
		cliente.setEstadoCivil(EstadoCivil.SOLTERO);
		cliente.setDni(dni);
		cliente.setFechaAlta(new Date());
		cliente.setLogin(login);
		cliente.setPassword("jaa");

		return RepositorioCliente.CrearCliente(cliente);
	}
	
	
	



	private static void modificarCliente(Integer idCliente) {

		final Cliente cliente = new Cliente();

		cliente.setNombre("Daniel2");
		cliente.setApellidos("rodriguez atenciano");
		cliente.setEdad(78);
		cliente.setEstadoCivil(EstadoCivil.SOLTERO);
		cliente.setDni("25143678V");
//		cliente.setIdPersona(1);

		RepositorioCliente.modificarCliente(cliente);
	}
 	 
	  
	 public static void consultarCliente(final Integer idCliente) {
		 final Cliente cliente = RepositorioCliente.consultarNombreCompleto(idCliente);
		 
//		 System.out.println(persona.getIdPersona());
		 System.out.println(cliente.getNombre());
		 System.out.println(cliente.getApellidos());
		 System.out.println(cliente.getEstadoCivil());
		 System.out.println(cliente.getEdad());
		 System.out.println(cliente.getDni());
	 }
	  
	 
	 private static void consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		 final List<Cliente> clientes =  RepositorioCliente.consultar(nombre,apellidos,dni,estadoCivil);
		 
		 System.out.println(clientes.size());
	 
	 }
}
