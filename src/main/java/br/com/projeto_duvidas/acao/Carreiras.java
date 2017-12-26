package br.com.projeto_duvidas.acao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projeto_duvidas.modelo.Carreira;
import br.com.projeto_duvidas.modelo.Ferramenta;
import br.com.projeto_duvidas.repositories.CarreiraRepository;
import br.com.projeto_duvidas.repositories.FerramentaRepository;

@Component
public class Carreiras implements Acao{
	
	@Autowired
	private CarreiraRepository carreiraRepository;
	
	@Autowired
	private FerramentaRepository ferramentaRepository;

	@Override
	public String executa(List<String> params) {
		System.out.println("entrou no EXECUTA de Carreiras");
		System.out.println("params: " + params);
		
		
		List<Ferramenta> ferramentas = new ArrayList<>();
		for(String s : params){
			for(Ferramenta f: ferramentaRepository.findAll()) {
				if(s.equals(f.getNome())){
					ferramentas.add(f);
				}
			}
		}
		System.out.println("ferramentas: " + ferramentas.toString());
		
		List<Carreira> carreiras = carreiraRepository.findByFerramentas(ferramentas);
		System.out.println("carreiras: " + carreiras.toString());

		for (Carreira carreira : carreiras) {
			System.out.println(carreira.getNome());
			System.out.println(carreira.getLink());
		}

		if (carreiras.isEmpty()) {
			return "não temos carreiras de " + params;
		} else {
			String resp = "";
			for (int i = 0; i < carreiras.size(); i++) {
				if (i == carreiras.size() - 1) {
					resp += carreiras.get(i).getNome() + " - " + carreiras.get(i).getLink() + ".";
				} else {
					resp += carreiras.get(i).getNome() + " - " + carreiras.get(i).getLink() + "\n";
				}
			}
			return "entendi, você deseja saber sobre carreiras da linguagem " + params + ". segue: " + "\n" + resp;
		}
	}
}
