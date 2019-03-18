package it.prova.gestionegarage.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Automobile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String marca;
	private String modello;
	private Integer cilindrata;
	private String targa;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "garage_id", nullable = true)
	private Garage garage;

	public Automobile() {

	}

	public Automobile(String marca, String modello, Integer cilindrata, String targa, Garage garage) {
		super();
		this.marca = marca;
		this.targa = targa;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.garage = garage;
	}

	public Automobile(String marca, String modello, Integer cilindrata) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
	}

	public Automobile(String marca, String modello, Garage garage) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.garage = garage;
	}

	public Automobile(String marca, String modello) {
		super();
		this.marca = marca;
		this.modello = modello;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Integer getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(Integer cilindrata) {
		this.cilindrata = cilindrata;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	@Override
	public String toString() {
		return "Automobile [id=" + id + ", marca=" + marca + ", modello=" + modello + ", cilindrata=" + cilindrata
				+ "]";
	}
}
