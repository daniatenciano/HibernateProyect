package es.aytos.hibernate.hibernate.conversores;


import javax.persistence.AttributeConverter;
import HibernateProyect.HibernateProyect.modelo.Genero;


public class Conversores implements AttributeConverter<Genero, String>{

	@Override
	public String convertToDatabaseColumn(Genero genero) {
		return genero.getCodigo();
	}

	@Override
	public Genero convertToEntityAttribute(String generoBBDD) {
		return Genero.getEnumerado(generoBBDD);
	}


}