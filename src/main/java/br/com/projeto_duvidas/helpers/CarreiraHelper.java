package br.com.projeto_duvidas.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.projeto_duvidas.modelo.Carreira;
import br.com.projeto_duvidas.modelo.Ferramenta;

public class CarreiraHelper {

	public List<Carreira> criaLista(Set<Carreira> carreiras, List<Ferramenta> ferramentas, String operador) {
		List<Carreira> listaCarreiras = new ArrayList<>();

		if (operador.equals("ou")) {
			for (Carreira carreira : carreiras) {
				listaCarreiras.add(carreira);
			}
		} else {

			int cont = 0;
			System.out.println("numero ferramentas: " + ferramentas.size());
			for (Carreira carreira : carreiras) {
				for (Ferramenta ferramenta : ferramentas) {
					if (carreira.getFerramentas().contains(ferramenta)) {
						cont++;
						System.out.println(carreira + "entrou no if e cont: " + cont);
					}
				}
				if (cont == ferramentas.size()) {
					listaCarreiras.add(carreira);
				}
				cont = 0;
			}
		}

		return listaCarreiras;
	}

	public String constroiResposta(List<Carreira> listaCarreiras, List<String> params) {
		if (listaCarreiras.isEmpty()) {
			return "não sabemos responder sobre carreiras de " + params
					+ ". use o canal duvidas_comercial para este fim.";
		} else {

			String resp = "";
			for (int i = 0; i < listaCarreiras.size(); i++) {
				if (i == listaCarreiras.size() - 1) {
					resp += listaCarreiras.get(i).getFerramentas() + ": " + listaCarreiras.get(i).getNome() + " - "
							+ listaCarreiras.get(i).getLink() + ".";
				} else {
					resp += listaCarreiras.get(i).getFerramentas() + ": " + listaCarreiras.get(i).getNome() + " - "
							+ listaCarreiras.get(i).getLink() + "\n";
				}
			}
			return "entendi, você deseja saber as carreiras sobre " + params + ". segue: " + "\n" + resp;
		}
	}
}
