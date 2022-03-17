package br.com.gerador.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerador.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

}
