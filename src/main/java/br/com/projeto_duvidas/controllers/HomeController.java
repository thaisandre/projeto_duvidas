package br.com.projeto_duvidas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{

   @GetMapping("/")
   public String index()
   {
      return "home/index";
   }
   
   @GetMapping("/teste")
   public String teste() {
	   return "home/teste";
   }
}
