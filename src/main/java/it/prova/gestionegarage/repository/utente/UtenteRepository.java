package it.prova.gestionegarage.repository.utente;

import org.springframework.data.repository.CrudRepository;

import it.prova.gestionegarage.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {

	Utente findByUsernameAndPassword(String username,String password);
}
