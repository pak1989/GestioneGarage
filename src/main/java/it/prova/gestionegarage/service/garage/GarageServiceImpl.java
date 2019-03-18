package it.prova.gestionegarage.service.garage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionegarage.model.Garage;
import it.prova.gestionegarage.repository.garage.GarageRepository;

@Component
public class GarageServiceImpl implements GarageService {

	@Autowired
	private GarageRepository garageRepository;

	@Transactional(readOnly = true)
	public List<Garage> listAllGarage() {
		return (List<Garage>) garageRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Garage caricaSingoloGarage(Long id) {
		return garageRepository.findOne(id);
	}

	@Transactional
	public void aggiorna(Garage garageInstance) {
		garageRepository.save(garageInstance);
	}

	@Transactional
	public void inserisciNuovo(Garage garageInstance) {
		garageRepository.save(garageInstance);
	}

	@Transactional
	public void rimuovi(Garage garageInstance) {
		garageRepository.delete(garageInstance);
	}

	@Transactional(readOnly = true)
	public List<Garage> findByExample(Garage garageExample) {
		 ExampleMatcher matcher = ExampleMatcher.matching()     
                 .withStringMatcher(StringMatcher.CONTAINING);   // Match string containing pattern   
                 //.withIgnoreCase();   
		return (List<Garage>) garageRepository.findAll(Example.of(garageExample,matcher));
	}

	@Transactional(readOnly = true)
	public List<Garage> cercaByNomeILike(String term) {
		return garageRepository.findAllByNomeContaining(term);
	}

}
