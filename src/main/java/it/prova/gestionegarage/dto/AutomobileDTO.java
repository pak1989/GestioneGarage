package it.prova.gestionegarage.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import it.prova.gestionegarage.model.Garage;

public class AutomobileDTO {

	private Long id;
	private String marca;
	private String modello;
	private int cilindrata;
	private String targa;
	private Garage garage;

	public AutomobileDTO() {

	}

	public AutomobileDTO(String marca, String modello, int cilindrata, Garage garage) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.garage = garage;
	}

	public AutomobileDTO(String marca, String modello, int cilindrata) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
	}

	public AutomobileDTO(String marca, String modello, Garage garage) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.garage = garage;
	}

	public AutomobileDTO(String marca, String modello, String targa) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
	}

	public AutomobileDTO(String marca, String modello) {
		super();
		this.marca = marca;
		this.modello = modello;
	}

	public AutomobileDTO(Long id, String marca, String modello, int cilindrata, Garage garage) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.garage = garage;
	}

	public AutomobileDTO(Long id, String marca, String modello, int cilindrata, String targa, Garage garage) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.targa = targa;
		this.garage = garage;
	}

	public AutomobileDTO(String marca, String modello, int cilindrata, String targa, Garage garage) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.targa = targa;
		this.garage = garage;
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

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
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

	public List<String> validate() {

		List<String> messagesList = new ArrayList<String>();

		if (StringUtils.isEmpty(marca) || StringUtils.isEmpty(modello) || StringUtils.isEmpty(cilindrata + "")) {
			messagesList.add("E' necessario riempire tutti i campi!");
		}

		String pattern = "^(([a-zA-Z]{2}\\d{3}[a-zA-Z]{2})|(([a-zA-Z]{2}|roma)(\\d{5}|\\d{6})))$";
		if (!targa.matches(pattern)) {
			messagesList.add("Targa non valida!");
		}

		if (cilindrata < 0 || !StringUtils.isNumeric(cilindrata + "")) {
			messagesList.add("Cilindrata non valida!");
		}

		if (garage == null) {
			messagesList.add("Selezionare un garage!");
		}

		return messagesList;
	}

}
