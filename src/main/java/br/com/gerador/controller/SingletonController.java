package br.com.gerador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gerador.singleton.Singleton;

@Controller
@RequestMapping("/singleton")
public class SingletonController {
	
		
	@GetMapping("/index")
	public String apresentaTitulo(Model model){
		
		String titulo = Singleton.getInstance().getTitulo(); 
		model.addAttribute("titulo", titulo);
		
		return "index.html";
			
	}
	
}
