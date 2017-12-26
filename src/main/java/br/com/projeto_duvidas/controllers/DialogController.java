package br.com.projeto_duvidas.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ai.api.model.Fulfillment;
import br.com.projeto_duvidas.acao.AcaoFactory;

@RequestMapping("dialog")
@RestController
public class DialogController {
	
	@Autowired
	AcaoFactory acaoFactory;
	
	@RequestMapping(value = "resposta", produces="application/json")
	public Fulfillment respostaLinguagem(@RequestBody String json) throws JsonProcessingException, IOException {
		
		System.out.println("entrou no dialog");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(json);
		
		JsonNode result = actualObj.get("result");
		
		JsonNode contexts = result.findValue("contexts");
		JsonNode parametros = contexts.findValue("parameters");
		JsonNode objetivoNode = parametros.findValue("objetivo");
		String objetivo = objetivoNode.toString().replace('\"', ' ').trim();
		System.out.println("objetivo: " + objetivo);
		
		JsonNode ferramentaNode = parametros.findValue("ferramenta");
				
		List<String> params = new ArrayList<>();
		for(int i = 0; i < ferramentaNode.size(); i++){
			params.add(ferramentaNode.get(i).toString().replace('\"', ' ').trim());
		}
		
		String resposta = acaoFactory.getAcao(objetivo).executa(params);
		
		Fulfillment f = new Fulfillment();	
		f.setSpeech(resposta);
		f.setDisplayText(resposta);
		
		return f;
		
	}
}
