package br.com.projeto_duvidas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projeto_duvidas.modelo.Carreira;
import br.com.projeto_duvidas.modelo.Curso;
import br.com.projeto_duvidas.repositories.CarreiraRepository;
import br.com.projeto_duvidas.repositories.CursoRepository;

@RequestMapping("/curso")
@Controller
public class CursoController {
	
	@Autowired
	private CarreiraRepository carreiraRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping("/form")
	public String form(Model model) {
		List<Carreira> carreiras = (List<Carreira>) carreiraRepository.findAll();
		model.addAttribute("carreiras", carreiras);
		List<Curso> cursos = (List<Curso>) cursoRepository.findAll();
		model.addAttribute("cursos", cursos);
		return "curso/form";
	}
	
	@ResponseBody
	@RequestMapping("adicionaCurso")
	public String adicionaCurso(Curso curso, Model model) {
		cursoRepository.save(curso);
		return "adicionado";
	}
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		List<Curso> cursos = (List<Curso>) cursoRepository.findAll();
		model.addAttribute("cursos", cursos);
		List<Carreira> carreiras = (List<Carreira>) carreiraRepository.findAll();
		model.addAttribute("carreiras", carreiras);
		return "curso/form";
	}
}
