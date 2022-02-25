package it.epicode.be.segreteria.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Studente {
	
	@NotEmpty(message = "Inserisci la Matricola!")
	private int matricola;
	@NotEmpty(message = "Inserisci il nome!")
	private String nome;
	@NotEmpty(message = "Inserisci il cognome!")
	private String cognome;
	@NotEmpty(message = "Inserisci la data di nascita!")
	private LocalDate dataNascita;
	@NotEmpty(message = "Inserisci la mail!")
	@Email(message = "Inserisci un formato valido per il campo 'Email'")
	private String mail;
	@NotEmpty(message = "Inserisci l'indirizzo")
	private String indirizzo;
	@NotEmpty(message = "Inserisci la città!")
	private String citta;
	@NotEmpty(message = "Scegli il corso di Studi!")
	private Corso corso;
	
	
	@Override
	public String toString() {
		return "Studente [matricola: " + matricola + ", nome: " + nome + ", cognome: " + cognome + ", dataNascita: "
				+ dataNascita + ", mail: " + mail + ", indirizzo: " + indirizzo + ", citta: " + citta + ", corso: " + corso
				+ "]";
	}
	
}
