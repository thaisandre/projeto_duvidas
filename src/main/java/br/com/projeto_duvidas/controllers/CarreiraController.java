package br.com.projeto_duvidas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto_duvidas.modelo.Carreira;
import br.com.projeto_duvidas.modelo.Curso;
import br.com.projeto_duvidas.modelo.Ferramenta;
import br.com.projeto_duvidas.modelo.TipoCarreira;
import br.com.projeto_duvidas.repositories.CarreiraRepository;
import br.com.projeto_duvidas.repositories.CursoRepository;
import br.com.projeto_duvidas.repositories.FerramentaRepository;

@RequestMapping("/carreira")
@Controller
public class CarreiraController {
	
	@Autowired
	CarreiraRepository carreiraRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	FerramentaRepository ferramentaRepository;
	
	@RequestMapping("form")
	public ModelAndView form(Carreira carreira, Ferramenta ferramenta, Curso curso) {
		ModelAndView modelAndView = new ModelAndView("carreira/form");
		modelAndView.addObject("tipos", TipoCarreira.values());
		
		List<Ferramenta> ferramentas = (List<Ferramenta>) ferramentaRepository.findAll();
		modelAndView.addObject("ferramentas", ferramentas);
		
		List<Curso> cursos = (List<Curso>) cursoRepository.findAll();
		modelAndView.addObject("cursos", cursos);
		
		List<Carreira> carreiras = (List<Carreira>) carreiraRepository.findAll();
		modelAndView.addObject("carreiras", carreiras);
		
		return modelAndView;
	}
	
	@RequestMapping("/adicionaCarreira")
	public String adiciona(Carreira carreira) {
		carreiraRepository.save(carreira);
		return "redirect:form";
	}
	
	@RequestMapping("removeCarreira")
	public String remove(Long id){
		carreiraRepository.delete(id);
		return "redirect:form";
	}
	
	@RequestMapping("mostraCarreira")
	public String mostra(Long id, Model model){
		Carreira carreira = carreiraRepository.findOne(id);
		model.addAttribute("carreira", carreira);
		
		ModelAndView modelAndView = new ModelAndView("carreira/form");
		modelAndView.addObject("tipos", TipoCarreira.values());
		
		List<Ferramenta> ferramentas = (List<Ferramenta>) ferramentaRepository.findAll();
		modelAndView.addObject("ferramentas", ferramentas);
		
		List<Curso> cursos = (List<Curso>) cursoRepository.findAll();
		modelAndView.addObject("cursos", cursos);
		
		
		
		return "carreira/mostra";
	}
	
	@RequestMapping("alteraCarreira")
	public String altera(Carreira carreira){
		carreiraRepository.save(carreira);
		return "redirect:form";
	}
}
