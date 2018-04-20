package es.aytos.hibernate.hibernate.repositorio;

import java.util.List;
import org.hibernate.Session;
import HibernateProyect.HibernateProyect.modelo.Aficiones;
import HibernateProyect.HibernateProyect.modelo.Persona;
import es.aytos.hibernate.hibernate.util.HibernateUtil;


public class RepositorioAficion {

	

	public static List<Aficiones> consultarAficiones() {
		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();
		try {
			sesion.beginTransaction();
			
			List<Aficiones> aficiones = (List<Aficiones>) sesion.createQuery("from Aficion").setCacheable(true).list();
			
			return aficiones;
			
		} catch (Exception e) {
			System.out.println("Se ha producido un error con la consulta: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

}
