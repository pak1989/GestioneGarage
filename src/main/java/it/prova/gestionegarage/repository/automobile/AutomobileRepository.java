package it.prova.gestionegarage.repository.automobile;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.gestionegarage.model.Automobile;

public interface AutomobileRepository extends CrudRepository<Automobile, Long>, QueryByExampleExecutor <Automobile> {

	// la query viene costruita in automatico!!!
	List<Automobile> findByMarca(String marca);

	// Anche questa!!!
	List<Automobile> findByCilindrataGreaterThan(int cilindrata);

	// Combinazione di campi!!! (Come i dynamic finders)
	List<Automobile> findByModelloAndCilindrata(String modello, int cilindrata);

	// Order by!!!!
	List<Automobile> findByCilindrataOrderByMarcaDesc(int cilindrta);
	
	 //se ho necessità particolari
	 @Query("from Automobile a where a.marca like ?1%")
	 List<Automobile> findByMarcaStartsWith(String token);
	 
	 List<Automobile> findByGarageId(Long id);

}
