package es.aytos.hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.Session;

import HibernateProyect.HibernateProyect.modelo.Cliente;
import HibernateProyect.HibernateProyect.modelo.EstadoCivil;
import HibernateProyect.HibernateProyect.modelo.Persona;
import es.aytos.hibernate.hibernate.util.HibernateUtil;

public class RepositorioCliente {
	
	public static Integer CrearCliente(final Cliente cliente) {

		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idPersona = (Integer) sesion.save(cliente);

			sesion.getTransaction().commit();

			return idPersona;

		} catch (Exception e) {

			System.out.println("Se ha producido un error insertando el cliente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();

		} finally {
			sesion.close();
		}
	}
	
	
	
	public static void modificarCliente(Cliente cliente) {
		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();

		try {
	
			sesion.beginTransaction();
			sesion.saveOrUpdate(cliente);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error creando un cliente: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}
	}

	public static void eliminarCliente(Cliente idCliente) {

		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("delete Persona where per_id = :idPersona").setParameter("idPersona", idCliente)
					.executeUpdate();

			// sesion.delete(persona);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Se ha producido un error creando un cliente: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}
	}

	
	public static Cliente consultarNombreCompleto(Integer idCliente) {
		final Session sesion = HibernateUtil.getMifactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			return (Cliente) sesion.createQuery("from Persona where per_id = :idPersona")
					.setParameter("idPersona", idCliente).uniqueResult();
		} catch (Exception e) {
			System.out.println("Se ha producido un error creando un cliente: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static List<Cliente> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
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

			final org.hibernate.query.Query<Cliente> consulta = sesion.createQuery(sb.toString());

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
			
//			if(login != null &&)

			return consulta.list();
		} catch (Exception e) {
			System.out.println("Se ha producido un error consultando a el cliente " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

}


