package es.aytos.hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.*;

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

			// sesion.createQuery("Update Persona set per nom = :nombre where per id =
			// :identificador")
			// .setParameter("nombre", nombre).setParameter("identificador",
			// idPersona).executeUpdate();

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

			sesion.createQuery("delete Persona where usu_id = :idPersona").setParameter("idPersona", idPersona)
					.executeUpdate();

			// sesion.delete(persona);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error creando una persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}
	}

	public static Persona consultarNombreCompleto(Integer idPersona) {
		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			 Persona persona =(Persona) sesion.createQuery("from Usuario Usu where Usu.idUsusario = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();

			 
			 return persona;
			 
		} catch (Exception e) {
			System.out.println("Se ha producido un error creando una persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static List<Persona> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil, String login) {
		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final StringBuilder sb = new StringBuilder("from Persona where 1=1");

			if (!nombre.isEmpty()) {
				sb.append("and PER_NOM like :nombre");

			}
			if (!apellidos.isEmpty()) {
				sb.append("and PER_APE like :apellidos");
			}

			if (!dni.isEmpty()) {
				sb.append("and PER_DNI = :dni");
			}

			if (estadoCivil != null) {
				sb.append("and PER_ECV = :estadoCivil");
			}

			final org.hibernate.query.Query<Persona> consulta = sesion.createQuery(sb.toString());

			if (!nombre.isEmpty()) {
				consulta.setParameter("nombre", nombre);
			}
			if (!apellidos.isEmpty()) {
				consulta.setParameter("apellidos", apellidos);
			}

			if (!dni.isEmpty()) {
				consulta.setParameter("dni", dni);
			}
			if (estadoCivil != null) {
				consulta.setParameter("estadoCivil", estadoCivil);
			}
			
//			if(login != null && ) {
//				consulta.setParameter("login", login);
//			}
			
			

			return consulta.list();
		} catch (Exception e) {
			System.out.println("Se ha producido un error consultando a la persona " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

}
