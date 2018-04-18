package es.aytos.hibernate.hibernate.repositorio;

import org.hibernate.*;
import HibernateProyect.HibernateProyect.modelo.*;
import es.aytos.hibernate.hibernate.util.*;

public class RepositorioCoche {

	public static Integer CrearCoche(final Coche coche) {

		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idCoche = (Integer) sesion.save(coche);

			sesion.getTransaction().commit();

			return idCoche;

		} catch (Exception e) {

			System.out.println("Se ha producido un error insertando el coche " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}

		finally {
			sesion.close();
		}
	}
	
//	public static void modificarCoche(final String marca, String modelo) {
//		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();
//
//		try {
//			sesion.beginTransaction();
//			
////			sesion.createQuery("Update Persona set per nom = :nombre where per id = :identificador")
////					.setParameter("nombre", nombre).setParameter("identificador", idPersona).executeUpdate();
//
//			// final Persona personaBBDD = (Persona)sesion.createQuery("from Persona where
//			// PER_ID = :idPersona")
//			// .setParameter("idPersona", idPersona).uniqueResult();
//			//
//			// personaBBDD.setNombre(nombre);
//			// personaBBDD.setApellidos("2");
//			// personaBBDD.setDni("111444777A");
//			// personaBBDD.setEdad(55);
//			// personaBBDD.setEstadoCivil(EstadoCivil.VIUDO);
//
//			
//			sesion.saveOrUpdate(persona);
//			sesion.getTransaction().commit();
//
//		} catch (Exception e) {
//			System.out.println("Se ha producido un error creando una persona: " + e.getMessage());
//			sesion.getTransaction().rollback();
//			throw new RuntimeException(e);
//
//		} finally {
//			sesion.close();
//		}

}
