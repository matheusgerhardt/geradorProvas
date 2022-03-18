package br.com.gerador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tags")
public class TagController {
	
	/*
	
	@Autowired 
	TagRepository dao;
	private TagService service;
	
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
	
	// Teste
	
	@GetMapping("/gettags")
	public ModelAndView getQuestoes() {
		
		ModelAndView mv = new ModelAndView("tag/list");
		
		mv.addObject("tags", service.getTags());
				
		return mv;
	}
	
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Tag tag) {
		service.salvar(tag);
		return "redirect:/tag/manterTag";
	
*/

}
