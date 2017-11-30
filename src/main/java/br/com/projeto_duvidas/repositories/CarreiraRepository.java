package br.com.projeto_duvidas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto_duvidas.modelo.Carreira;

@Repository
public interface CarreiraRepository extends CrudRepository<Carreira, Long>  {

}