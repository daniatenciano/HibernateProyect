package es.aytos.hibernate.hibernate.pruebas;

import java.util.List;
import HibernateProyect.HibernateProyect.modelo.Aficiones;
import es.aytos.hibernate.hibernate.repositorio.RepositorioAficion;

public class PruebaCache {

	public static void main(String[] args) {
		consultarAficiones();
		consultarAficiones();
	}
	
	private static void consultarAficiones() {
		final List<Aficiones> aficiones = RepositorioAficion.consultarAficiones();
		
//		aficiones.stream().map(Aficiones::getNombre).forEach(System.out::println);
	}

	
	
}
