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

import br.com.gerador.dao.TagRepository;
import br.com.gerador.model.Tag;

@Controller
@RequestMapping("/tags")
public class TagController {
	
	@Autowired 
	TagRepository dao;
	
	@GetMapping("/new")
	public String newForm(Model model) {
		Tag tag = new Tag();
		model.addAttribute("tag", tag);
		return "tag/manterTag.html";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		dao.deleteById(id);
		return "redirect:/tags/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Tag tag = dao.getOne(id);
		model.addAttribute("tag", tag);
		return "tag/manterTag.html";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Tag> tagList = dao.findAll();
		model.addAttribute("tagList", tagList);
		return "tag/list.html";
	}
	
	@PostMapping("/save")
	public String save(@Valid Tag tag, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "tag/manterTag.html";
		}
		dao.save(tag);
		return "redirect:/tags/list";
	}
	

}
