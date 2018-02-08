package br.com.projeto_duvidas.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.com.projeto_duvidas.modelo.Carreira;
import br.com.projeto_duvidas.modelo.Ferramenta;

@Repository
public interface CarreiraRepository extends CrudRepository<Carreira, Long>, QueryByExampleExecutor<Carreira>   {
		
	Set<Carreira> findByFerramentasIn(List<Ferramenta> ferramentas);

	Iterable<Carreira> findByFerramentasLike(List<Ferramenta> ferramentas);
	
}