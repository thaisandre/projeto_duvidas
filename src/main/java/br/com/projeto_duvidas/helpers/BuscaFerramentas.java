package br.com.projeto_duvidas.helpers;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto_duvidas.modelo.Ferramenta;
import br.com.projeto_duvidas.repositories.FerramentaRepository;

public class BuscaFerramentas {
	 
	public List<Ferramenta> criaLista(List<String> params, FerramentaRepository repository){
		List<Ferramenta> ferramentas = new ArrayList<>();
		for (String s : params) {
			for (Ferramenta f : repository.findAll()) {
				if (s.equals(f.getNome())) {
					ferramentas.add(f);
				}
			}
		}
		
		return ferramentas;
	}
}
