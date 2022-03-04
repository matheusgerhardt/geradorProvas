package br.com.gerador.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerador.model.Prova;

public interface ProvaRepository extends JpaRepository<Prova, Long>{

}
