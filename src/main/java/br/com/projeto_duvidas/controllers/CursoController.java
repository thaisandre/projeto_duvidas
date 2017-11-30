package br.com.projeto_duvidas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/curso")
@Controller
public class CursoController {
	
	@GetMapping("/form")
	public String form() {
		return "curso/form";
	}

}
