package it.prova.gestionegarage.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import it.prova.gestionegarage.model.Automobile;

public class GarageDTO {

	private Long id;
	private String nome;
	private String descrizione;
	private String indirizzo;
	private Set<Automobile> automobili = new HashSet<>();

	public GarageDTO() {
	}

	public GarageDTO(Long id, String nome, String descrizione, String indirizzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.indirizzo = indirizzo;
	}

	public GarageDTO(String nome, String descrizione, String indirizzo) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.indirizzo = indirizzo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Set<Automobile> getAutomobili() {
		return automobili;
	}

	public void setAutomobili(Set<Automobile> automobili) {
		this.automobili = automobili;
	}

	public List<String> validate() {

		List<String> messagesList = new ArrayList<String>();

		if (StringUtils.isEmpty(nome) || StringUtils.isEmpty(descrizione) || StringUtils.isEmpty(indirizzo)) {
			messagesList.add("E' necessario riempire tutti i campi!");
		}

		if (id != null) {
			if (StringUtils.isEmpty(id + "") || id < 1 || !StringUtils.isNumeric(id + "")) {
				messagesList.add("ID non valido!");
			}
		}

		return messagesList;
	}

}
