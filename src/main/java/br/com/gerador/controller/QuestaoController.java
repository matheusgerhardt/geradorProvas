package br.com.gerador.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gerador.dao.QuestaoRepository;
import br.com.gerador.model.Questao;
import br.com.gerador.service.QuestaoService;
import br.com.gerador.service.TagService;


@Controller
@RequestMapping("/questoes")
public class QuestaoController {
	@Autowired
	QuestaoRepository daoQuestao;
	//private QuestaoService service;
	//private TagService tagService;
	
	@GetMapping("/new")
	public String newForm(Model model) {
		Questao questao = new Questao();
		model.addAttribute("questao", questao);
		return "questao/manterQuestao.html";
	}
	
	@GetMapping("/delete/{idQuestao}")
	public String delete(@PathVariable Long idQuestao) {
		daoQuestao.deleteById(idQuestao);
		return "redirect:/questoes/list";
	}
	
	@GetMapping("/edit/{idQuestao}")
	public String edit(@PathVariable Long idQuestao, Model model) {
		Questao questao = daoQuestao.getOne(idQuestao);
		model.addAttribute("questao", questao);
		return "questao/manterQuestao.html";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Questao> questaoList = daoQuestao.findAll();
		model.addAttribute("questaoList", questaoList);
		return "questao/list.html";
	}
	
	@PostMapping("/save")
	public String save(@Valid Questao questao, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "questao/manterQuestao.html";
		}
		daoQuestao.save(questao);
		return "redirect:/questao/list";
	}
	
	/*
	
	@GetMapping("/getquestoes")
	public ModelAndView getQuestoes() {
		
		ModelAndView mv = new ModelAndView("questao/manterQuestao");
		
		mv.addObject("questao", new Questao());
		mv.addObject("questoes", service.getQuestoes());
		mv.addObject("tags", tagService.getTags());
		
		return mv;
	}
	
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Questao questao) {
		service.salvar(questao);
		return "redirect:/questao/manterQuestao";
	}
	*/
	
	
}
