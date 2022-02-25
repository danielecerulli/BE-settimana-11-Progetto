package it.epicode.be.segreteria.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.epicode.be.segreteria.config.SegreteriaConfig;
import it.epicode.be.segreteria.util.GestioneSegreteria;


@Component
public class CorsoConverter implements Converter<String, Corso> {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	private Segreteria segreteria;
	private ApplicationContext ctx;
	
	public CorsoConverter() {
		ctx = new AnnotationConfigApplicationContext(SegreteriaConfig.class); 
		segreteria = (Segreteria) ctx.getBean("segreteria"); 
	}
	
	@Override
	public Corso convert(String idCorso) {
		Segreteria segreteria = (Segreteria)ctx.getBean("segreteria");
		Corso corso = null;
		List<Corso> listaCorsi = segreteria.getListaCorsi();
		
		for (Corso c : listaCorsi ) {
			if ( Integer.toString(c.getIdCorso()).equals(idCorso) ) {
				log.info("ID CORSO CorsoConverterClass(nell'if): " + idCorso);
				corso = c;
				log.info("IdCorso linea 39 CorsoConverter: " + corso.getIdCorso());
			}
			
		}	
		log.info("ID corso corsoConverterClass(dopo l'if): " + corso.getIdCorso() + " Materia: " + corso.getMateria());
		return corso;
	}

}
