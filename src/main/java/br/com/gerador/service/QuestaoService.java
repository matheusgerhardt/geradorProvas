package br.com.gerador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gerador.dao.QuestaoRepository;
import br.com.gerador.model.Questao;

public class QuestaoService {
	
	@Autowired(required=true)
	private QuestaoRepository repository;
	
	public List<Questao> getQuestoes(){
		return repository.findAll();
	}
	
	public void salvar(Questao questao) {
		repository.save(questao);
	}

}
