package br.com.projeto_duvidas.acao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projeto_duvidas.modelo.Carreira;
import br.com.projeto_duvidas.repositories.CarreiraRepository;

@Component
public class Carreiras implements Acao{
	
	@Autowired
	private CarreiraRepository carreiraRepository;

	@Override
	public String executa(String param) {
		System.out.println("entrou no EXECUTA");
		System.out.println("param: " + param);
		
		
		List<Carreira> carreiras = carreiraRepository.findByLinguagem(param);
		System.out.println(carreiras.toString());

		for (Carreira carreira : carreiras) {
			System.out.println(carreira.getNome());
			System.out.println(carreira.getLink());
		}

		if (carreiras.isEmpty()) {
			return "não temos carreiras de " + param;
		} else {
			String resp = "";
			for (int i = 0; i < carreiras.size(); i++) {
				if (i == carreiras.size() - 1) {
					resp += carreiras.get(i).getNome() + " - " + carreiras.get(i).getLink() + ".";
				} else {
					resp += carreiras.get(i).getNome() + " - " + carreiras.get(i).getLink() + "\n";
				}
			}
			return "entendi, você deseja saber sobre carreiras da linguagem " + param + ". segue: " + "\n" + resp;
		}
	}
}
