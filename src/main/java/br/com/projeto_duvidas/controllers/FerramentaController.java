package br.com.projeto_duvidas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto_duvidas.modelo.Ferramenta;
import br.com.projeto_duvidas.modelo.TipoFerramenta;
import br.com.projeto_duvidas.repositories.FerramentaRepository;

@RequestMapping("/ferramenta")
@Controller
public class FerramentaController {
	
	@Autowired
	FerramentaRepository ferramentaRepository;
	
	@RequestMapping("/form")
	public ModelAndView form(Ferramenta ferramenta){
		ModelAndView modelAndView = new ModelAndView("ferramenta/form");
		modelAndView.addObject("tipos", TipoFerramenta.values());
		
		List<Ferramenta> ferramentas = (List<Ferramenta>) ferramentaRepository.findAll();
		modelAndView.addObject("ferramentas", ferramentas);
		return modelAndView;
	}
	
	@RequestMapping("adicionaFerramenta")
	public String adiciona(Ferramenta ferramenta) {
		ferramentaRepository.save(ferramenta);
		return "redirect:form";
	}
	
	@RequestMapping("removeFerramenta")
	public String remove(Long id){
		ferramentaRepository.delete(id);
		return "redirect:form";
	}
	
	@RequestMapping("mostraFerramenta")
	public String mostra(Model model, Long id){
		Ferramenta ferramenta = ferramentaRepository.findOne(id);
		model.addAttribute("ferramenta", ferramenta);
		return "ferramenta/mostra";
	}
	
	@RequestMapping("alteraFerramenta")
	public String altera(Ferramenta ferramenta){
		ferramentaRepository.save(ferramenta);
		return "redirect:form";
	}

}
