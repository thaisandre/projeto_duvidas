package br.com.projeto_duvidas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto_duvidas.modelo.Carreira;
import br.com.projeto_duvidas.modelo.Curso;
import br.com.projeto_duvidas.modelo.Ferramenta;
import br.com.projeto_duvidas.modelo.TipoCurso;
import br.com.projeto_duvidas.repositories.CarreiraRepository;
import br.com.projeto_duvidas.repositories.CursoRepository;
import br.com.projeto_duvidas.repositories.FerramentaRepository;

@RequestMapping("/curso")
@Controller
public class CursoController {
	
	@Autowired
	private CarreiraRepository carreiraRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	FerramentaRepository ferramentaRepository;
	
	@GetMapping("/form")
	public ModelAndView form(Curso curso) {
		ModelAndView modelAndView = new ModelAndView("curso/form");
		
		List<Carreira> carreiras = (List<Carreira>) carreiraRepository.findAll();
		modelAndView.addObject("carreiras", carreiras);
		
		List<Curso> cursos = (List<Curso>) cursoRepository.findAll();
		modelAndView.addObject("cursos", cursos);
		
		List<Ferramenta> ferramentas = (List<Ferramenta>) ferramentaRepository.findAll();
		modelAndView.addObject("ferramentas", ferramentas);
		
		modelAndView.addObject("tipos", TipoCurso.values());
		
		return modelAndView;
	}
	
	@RequestMapping("adicionaCurso")
	public String adicionaCurso(Curso curso) {
		cursoRepository.save(curso);
		return "redirect:form";
	}
	
	@RequestMapping("removeCurso")
	public String remove(Long id){
		cursoRepository.delete(id);
		return "redirect:form";
	}
	
	@RequestMapping("mostraCurso")
	public String mostra(Long id, Model model){
		Curso curso = cursoRepository.findOne(id);
		model.addAttribute("curso", curso);
		return "curso/mostra";
	}
	
	@RequestMapping("alteraCurso")
	public String altera(Curso curso){
		cursoRepository.save(curso);
		return "redirect:form";
	}
}
