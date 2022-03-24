package br.com.gerador.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerador.model.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {
	
	

}
