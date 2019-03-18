package it.prova.gestionegarage.service.automobile;

import java.util.List;

import it.prova.gestionegarage.model.Automobile;

public interface AutomobileService {
	
	public List<Automobile> listAllAutomobili();

	public Automobile caricaSingoloAutomobile(Long id);

	public void aggiorna(Automobile automobileInstance);

	public void inserisciNuovo(Automobile automobileInstance);

	public void rimuovi(Automobile automobileInstance);

	public List<Automobile> findByExample(Automobile example);
	
	public List<Automobile> findByMarca(String nameInput);
	
	public List<Automobile> cercaAutomobiliConCilindrataMaggioreDi(int cilindrataInput);
	
	public List<Automobile> cercaAutomobiliPerModelloAndCilindrata(String modelloInput, int etaInput);
	
	public List<Automobile> cercaAutomobiliByCilindrataOrdinaPerMarcaDesc(int cilindrata);
	
	public List<Automobile> cercaPerMarcaCheIniziaCon(String tokenIniziale);
	
	public List<Automobile> cercaPerGarageId(Long garageId);	
	
}
