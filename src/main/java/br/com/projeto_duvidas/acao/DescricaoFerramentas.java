package br.com.projeto_duvidas.acao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projeto_duvidas.modelo.Ferramenta;
import br.com.projeto_duvidas.repositories.FerramentaRepository;

@Component
public class DescricaoFerramentas implements Acao {

	@Autowired
	private FerramentaRepository ferramentaRepository;

	@Override
	public String executa(List<String> params) {
		System.out.println("ENTROU NO EXECUTA DO DESCRIÇÃO");
		System.out.println(params.toString());
		
		List<Ferramenta> ferramentas = new ArrayList<>();
		for(String s : params){
			for(Ferramenta f: ferramentaRepository.findAll()) {
				if(s.equals(f.getNome())){
					ferramentas.add(f);
				}
			}
		}
		System.out.println("ferramentas: " + ferramentas.toString());
		
		//List<Carreira> carreiras = carreiraRepository.findByFerramentasIn(ferramentas);
		//System.out.println("carreiras: " + carreiras.toString());

		if (ferramentas.isEmpty()) {
			return "não temos informações das ferramentas " + params;
		} else {
			String resp = "";
			for (int i = 0; i < ferramentas.size(); i++) {
				if (i == ferramentas.size() - 1) {
					resp += ferramentas.get(i).getNome() + " - " + ferramentas.get(i).getDescricao() + ".";
				} else {
					resp += ferramentas.get(i).getNome() + " - " + ferramentas.get(i).getDescricao() + "\n";
				}
			}
			return "entendi, você deseja saber sobre as ferramentas " + params + ". segue: " + "\n" + resp;
		}
	}
	
	
}
