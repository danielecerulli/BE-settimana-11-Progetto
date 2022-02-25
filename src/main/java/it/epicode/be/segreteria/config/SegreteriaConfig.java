package it.epicode.be.segreteria.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.be.segreteria.model.Corso;
import it.epicode.be.segreteria.model.CorsoChimica;
import it.epicode.be.segreteria.model.CorsoFisica;
import it.epicode.be.segreteria.model.CorsoLettere;
import it.epicode.be.segreteria.model.Segreteria;
import it.epicode.be.segreteria.model.Studente;

@Configuration
public class SegreteriaConfig {
	
	@Bean
	public Segreteria segreteria() {
		
		Segreteria segreteria = new Segreteria();
		// studenti
		segreteria.getListaStudenti().addAll(studenti());
		segreteria.getListaStudenti();
		
		// corsi
		segreteria.getListaCorsi().add(corsofisica());
		segreteria.getListaCorsi().add(corsolettere());
		segreteria.getListaCorsi().add(corsochimica());
		
		return segreteria;
		
	}
	@Bean
	public Studente studente() {
		
		return new Studente();
	}
	@Bean
	public Corso corso() {
		return new Corso();
	}
	
	@Bean 
	public CorsoFisica corsofisica() {
		return new CorsoFisica();
	}
	
	@Bean 
	public CorsoLettere corsolettere() {
		return new CorsoLettere();
	}
	
	@Bean 
	public CorsoChimica corsochimica() {
		return new CorsoChimica();
	}
	
	@Bean
	public List<Studente> studenti() {
		List<Studente> listaStudInit = new ArrayList<Studente>();
		Corso fisica = corsofisica();
		Corso lettere = corsolettere();
		Corso chimica = corsochimica();
		
		Studente s1 = new Studente(1, "Daniele", "Cerulli", LocalDate.parse("1992-03-13"), "danielecerulli@libero.it", "via E. Buccarelli 119", "Fiumicino", fisica);
		Studente s2 = new Studente(2, "Gianni", "Celeste", LocalDate.parse("1964-07-11"), "g.celeste@gmail.com", "via Gigi 10", "Napoli", lettere);
		Studente s3 = new Studente(3, "Ugo", "Rossi", LocalDate.parse("1981-11-10"), "ugo.rossi@yahoo.it", "via Giolitti 3", "Roma", chimica);
		
		listaStudInit.add(s1);
		listaStudInit.add(s2);
		listaStudInit.add(s3);
		return listaStudInit;
	}
	
	
}
