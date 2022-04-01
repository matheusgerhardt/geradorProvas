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
import br.com.gerador.dao.RespostaAbertaRepository;
import br.com.gerador.model.Questao;
import br.com.gerador.model.respostaAberta;
import br.com.gerador.model.respostaMultipla;
import br.com.gerador.model.respostaUnica;
import br.com.gerador.model.tipoQuestao;


@Controller
@RequestMapping("/questoes")
public class QuestaoController {
	@Autowired
	QuestaoRepository daoQuestao;
	
	@Autowired
	RespostaAbertaRepository daoRespostaAberta;
	
	
	//private QuestaoService service;
	//private TagService tagService;
	
	@GetMapping("/new")
	public String newForm(Model model) {
		Questao questao = new Questao();
		respostaUnica respostaunica = new respostaUnica();
		respostaMultipla respostamultipla = new respostaMultipla();
		model.addAttribute("questao", questao);
		model.addAttribute("respostaUnica", respostaunica);
		model.addAttribute("respostaMultipla", respostamultipla);
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
	
	@GetMapping("/listProva")
	public String listProva(Model model) {
		List<Questao> questaoList = daoQuestao.findAll();
		model.addAttribute("questaoList", questaoList);
		return "questao/listCadastroQuestao.html";
	}
	
	@PostMapping("/save")
	public String save(@Valid Questao questao, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "questao/manterQuestao.html";
		}
		daoQuestao.save(questao);
		return "redirect:/questoes/list";
	}
	
	@PostMapping("/saveAberta")
	public String saveAberta(@Valid Questao questao, respostaAberta respostaAberta, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "questao/manterQuestao.html";
		}
		questao.setTipoQuestao(tipoQuestao.ABERTA);
		questao.setRespostaAberta(respostaAberta);
		daoQuestao.save(questao);
		
		return "redirect:/questoes/list";
	}
	
	@PostMapping("/saveUnica")
	public String saveUnica(@Valid Questao questao, respostaUnica respostaUnica, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "questao/manterQuestao.html";
		}
		questao.setTipoQuestao(tipoQuestao.UNICA);
		questao.setRespostaUnica(respostaUnica);
		daoQuestao.save(questao);
		return "redirect:/questoes/list";
	}
	
	@PostMapping("/saveMultipla")
	public String saveMultipla(@Valid Questao questao, respostaMultipla respostaMultipla, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "questao/manterQuestao.html";
		}
		questao.setTipoQuestao(tipoQuestao.MULTIPLA);
		questao.setRespostaMultipla(respostaMultipla);
		daoQuestao.save(questao);
		return "redirect:/questoes/list";
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
