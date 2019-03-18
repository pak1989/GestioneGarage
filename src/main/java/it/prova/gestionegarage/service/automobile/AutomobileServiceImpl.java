package it.prova.gestionegarage.service.automobile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionegarage.model.Automobile;
import it.prova.gestionegarage.repository.automobile.AutomobileRepository;

@Component
public class AutomobileServiceImpl implements AutomobileService {

	@Autowired
	private AutomobileRepository automobileRepository;

	@Transactional(readOnly = true)
	public List<Automobile> listAllAutomobili() {
		return (List<Automobile>) automobileRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Automobile caricaSingoloAutomobile(Long id) {
		return automobileRepository.findOne(id);

	}

	@Transactional
	public void aggiorna(Automobile automobileInstance) {
		automobileRepository.save(automobileInstance);
	}

	@Transactional
	public void inserisciNuovo(Automobile automobileInstance) {
		automobileRepository.save(automobileInstance);
	}

	@Transactional
	public void rimuovi(Automobile automobileInstance) {
		automobileRepository.delete(automobileInstance);
	}

	@Transactional(readOnly = true)
	public List<Automobile> findByExample(Automobile automobileExample) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
		//.withIgnoreNullValues();
		// Match string containing pattern.withIgnoreCase();
		return (List<Automobile>) automobileRepository.findAll(Example.of(automobileExample, matcher));
	}

	@Transactional(readOnly = true)
	public List<Automobile> findByMarca(String marcaInput) {
		return automobileRepository.findByMarca(marcaInput);
	}

	@Transactional(readOnly = true)
	public List<Automobile> cercaAutomobiliConCilindrataMaggioreDi(int cilindrataInput) {
		return automobileRepository.findByCilindrataGreaterThan(cilindrataInput);
	}

	@Transactional(readOnly = true)
	public List<Automobile> cercaAutomobiliByCilindrataOrdinaPerMarcaDesc(int cilindrata) {
		return automobileRepository.findByCilindrataOrderByMarcaDesc(cilindrata);
	}

	@Transactional(readOnly = true)
	public List<Automobile> cercaPerMarcaCheIniziaCon(String tokenIniziale) {
		return automobileRepository.findByMarcaStartsWith(tokenIniziale);
	}

	@Transactional(readOnly = true)
	public List<Automobile> cercaAutomobiliPerModelloAndCilindrata(String modelloInput, int cilindrataInput) {
		return automobileRepository.findByModelloAndCilindrata(modelloInput, cilindrataInput);
	}

	@Transactional(readOnly = true)
	public List<Automobile> cercaPerGarageId(Long garageId) {
		return automobileRepository.findByGarageId(garageId);
	}

}
