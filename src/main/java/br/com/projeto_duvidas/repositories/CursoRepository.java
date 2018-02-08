package br.com.projeto_duvidas.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto_duvidas.modelo.Curso;
import br.com.projeto_duvidas.modelo.Ferramenta;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {

	Set<Curso> findByFerramentasIn(List<Ferramenta> ferramentas);

}
