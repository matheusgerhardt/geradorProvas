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

import br.com.gerador.dao.QuestaoRepository;
import br.com.gerador.model.Prova;
import br.com.gerador.model.Questao;

@Controller
@RequestMapping("/questoes")
public class QuestaoController {
	@Autowired
	QuestaoRepository daoQuestao;
	
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
		return "redirect:/questoes/list";
	}
}
