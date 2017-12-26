package br.com.projeto_duvidas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto_duvidas.modelo.Carreira;
import br.com.projeto_duvidas.modelo.Ferramenta;

@Repository
public interface CarreiraRepository extends CrudRepository<Carreira, Long>  {

	List<Carreira> findByFerramentas(List<Ferramenta> ferramentas);
}