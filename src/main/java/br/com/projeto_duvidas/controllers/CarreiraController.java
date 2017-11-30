package br.com.projeto_duvidas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projeto_duvidas.modelo.Carreira;
import br.com.projeto_duvidas.repositories.CarreiraRepository;

@RequestMapping("/carreira")
@Controller
public class CarreiraController {
	
	@Autowired
	CarreiraRepository carreiraRepository;
	
	@RequestMapping("form")
	public String form() {
		return "carreira/form";
	}
	
	@ResponseBody
	@RequestMapping("/adiciona")
	public String adiciona(Carreira carreira) {
		carreiraRepository.save(carreira);
		return "adicionado";
	}
}
