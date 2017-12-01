package br.com.projeto_duvidas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String form(Model model) {
		return lista(model);
	}
	
	@ResponseBody
	@RequestMapping("/adiciona")
	public String adiciona(Carreira carreira) {
		carreiraRepository.save(carreira);
		return "adicionado";
	}
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		List<Carreira> carreiras = (List<Carreira>) carreiraRepository.findAll();
		model.addAttribute("carreiras", carreiras);
		return "carreira/form";		
	}
}
