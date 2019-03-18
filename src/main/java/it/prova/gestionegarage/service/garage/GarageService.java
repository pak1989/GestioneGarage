package it.prova.gestionegarage.service.garage;

import java.util.List;

import it.prova.gestionegarage.model.Garage;

public interface GarageService {
	
	public List<Garage> listAllGarage() ;

	public Garage caricaSingoloGarage(Long id);

	public void aggiorna(Garage garageInstance);

	public void inserisciNuovo(Garage garageInstance);

	public void rimuovi(Garage municipioInstance);

	public List<Garage> findByExample(Garage example);
	
	public List<Garage> cercaByNomeILike(String term);

}
