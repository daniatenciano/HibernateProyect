package es.aytos.hibernate.hibernate.repositorio;

import org.hibernate.*;
import org.hibernate.mapping.List;
import HibernateProyect.HibernateProyect.modelo.*;
import es.aytos.hibernate.hibernate.util.*;

public class RepositorioPersona {

	public static Integer CrearPersona(final Persona persona) {

		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idPersona = (Integer) sesion.save(persona);

			sesion.getTransaction().commit();

			return idPersona;

		} catch (Exception e) {

			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		
		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona(Persona persona) {
		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();

		try {
			sesion.beginTransaction();
			
//			sesion.createQuery("Update Persona set per nom = :nombre where per id = :identificador")
//					.setParameter("nombre", nombre).setParameter("identificador", idPersona).executeUpdate();

			// final Persona personaBBDD = (Persona)sesion.createQuery("from Persona where
			// PER_ID = :idPersona")
			// .setParameter("idPersona", idPersona).uniqueResult();
			//
			// personaBBDD.setNombre(nombre);
			// personaBBDD.setApellidos("2");
			// personaBBDD.setDni("111444777A");
			// personaBBDD.setEdad(55);
			// personaBBDD.setEstadoCivil(EstadoCivil.VIUDO);

			
			sesion.saveOrUpdate(persona);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error creando una persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}
	}
	
	public static void eliminarPersona(Integer idPersona) {
		
		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();

		try {
			sesion.beginTransaction();
			
//			sesion.createQuery("Delete Persona where per_id = :identificador")
//					.setParameter("nombre", nombre).setParameter("identificador", idPersona).executeUpdate();

			
			// .setParameter("idPersona", idPersona).uniqueResult();
			//
			// personaBBDD.setNombre(nombre);
			// personaBBDD.setApellidos("2");
			// personaBBDD.setDni("111444777A");
			// personaBBDD.setEdad(55);
			// personaBBDD.setEstadoCivil(EstadoCivil.VIUDO);
//			final Persona personaBBDD = (persona)SESION.CREATEQUERY("FROM PERSONA WHERE
//					 PER_ID = :IDENTIFICADOR")
			
			sesion.createQuery("delete Persona where per_id = :idPersona")
			.setParameter("idPersona", idPersona).executeUpdate();
	
//			sesion.delete(persona);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error creando una persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}
	}
	
	

	public static List<Persona> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();
		
		try {
			sesion.beginTransaction();
			
			final org.hibernate.query.Query<Persona> consulta = sesion
					.createQuery("from persona where PER_NOM  like :nombre and PER_APE like :apellidos");
			
			
			consulta.setParameter("nombre", nombre);
			consulta.set
			
			
			
			return  consulta.list();
		}catch(Exception e) {
			System.out.println("Se ha producido un error consultando a la persona " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}
}
