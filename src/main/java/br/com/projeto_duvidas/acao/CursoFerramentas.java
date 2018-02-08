package br.com.projeto_duvidas.acao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projeto_duvidas.modelo.Curso;
import br.com.projeto_duvidas.modelo.Ferramenta;
import br.com.projeto_duvidas.repositories.CursoRepository;
import br.com.projeto_duvidas.repositories.FerramentaRepository;

@Component
public class CursoFerramentas implements Acao {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private FerramentaRepository ferramentaRepository;

	@Override
	public String executa(List<String> params, String operador) {
		System.out.println("entrou no EXECUTA de Carreiras");
		System.out.println("params: " + params);

		List<Ferramenta> ferramentas = criaLista(params);
		System.out.println("ferramentas: " + ferramentas.toString());

		Set<Curso> cursos = cursoRepository.findByFerramentasIn(ferramentas);
		System.out.println("cursos: " + cursos.toString());

		List<Curso> listaCursos = criaLista(cursos, ferramentas, operador);

		return criaResposta(params, listaCursos);
	}

	private List<Ferramenta> criaLista(List<String> params) {
		List<Ferramenta> ferramentas = new ArrayList<>();
		for (String s : params) {
			for (Ferramenta f : ferramentaRepository.findAll()) {
				if (s.equals(f.getNome())) {
					ferramentas.add(f);
				}
			}
		}

		return ferramentas;
	}

	private List<Curso> criaLista(Set<Curso> cursos, List<Ferramenta> ferramentas, String operador) {
		List<Curso> listaCursos = new ArrayList<>();

		if (operador.equals("ou")) {
			for (Curso curso : cursos) {
				listaCursos.add(curso);
			}
		} else {

			int cont = 0;
			System.out.println("numero ferramentas: " + ferramentas.size());
			for (Curso curso : cursos) {
				for (Ferramenta ferramenta : ferramentas) {
					if (curso.getFerramentas().contains(ferramenta)) {
						cont++;
						System.out.println(curso + "entrou no if e cont: " + cont);
					}
				}
				if (cont == ferramentas.size()) {
					listaCursos.add(curso);
				}
				cont = 0;
			}
		}

		return listaCursos;
	}

	private String criaResposta(List<String> params, List<Curso> cursos) {
		if (cursos.isEmpty()) {
			return "não sabemos responder sobre cursos de " + params + ". use o canal duvidas_comercial para este fim.";
		} else {
			String resp = "";
			for (int i = 0; i < cursos.size(); i++) {
				if (i == cursos.size() - 1) {
					resp += cursos.get(i).getFerramentas() + ": " + cursos.get(i).getNome() + " - "
							+ cursos.get(i).getLink() + ".";
				} else {
					resp += cursos.get(i).getFerramentas() + ": " + cursos.get(i).getNome() + " - "
							+ cursos.get(i).getLink() + "\n";
				}
			}
			return "entendi, você deseja saber os cursos sobre " + params + ". segue: " + "\n" + resp;
		}
	}

}
