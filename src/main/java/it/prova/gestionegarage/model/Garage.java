package it.prova.gestionegarage.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Garage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descrizione;
	private String indirizzo;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "garage", orphanRemoval = true)
	private Set<Automobile> automobili = new HashSet<>();

	public Garage() {
	}

	public Garage(String nome, String descrizione, String indirizzo) {
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

	@Override
	public String toString() {
		return "Garage [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", indirizzo=" + indirizzo
				+ "]";
	}

}
