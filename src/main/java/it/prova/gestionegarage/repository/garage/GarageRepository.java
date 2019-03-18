package it.prova.gestionegarage.repository.garage;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.gestionegarage.model.Garage;

public interface GarageRepository extends CrudRepository<Garage, Long>, QueryByExampleExecutor <Garage> {

	List<Garage> findAllByNomeContaining(String term);

}
