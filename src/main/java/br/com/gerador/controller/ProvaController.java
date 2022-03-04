package br.com.gerador.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gerador.dao.ProvaRepository;
import br.com.gerador.model.Prova;


@Controller
@RequestMapping("/provas")
public class ProvaController {
	
	@Autowired
	ProvaRepository dao;
	
	@GetMapping("/new")
	public String newForm(Model model) {
		Prova prova = new Prova();
		model.addAttribute("prova", prova);
		return "prova/manterProva.html";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		dao.deleteById(id);
		return "redirect:/prova/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Prova prova = dao.getOne(id);
		model.addAttribute("prova", prova);
		return "prova/manterProva.html";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Prova> provaList = dao.findAll();
		model.addAttribute("provaList", provaList);
		return "prova/list.html";
	}
	
	@PostMapping("/save")
	public String save(@Valid Prova prova, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "prova/manterProva.html";
		}
		dao.save(prova);
		return "redirect:/prova/list";
	}
}
