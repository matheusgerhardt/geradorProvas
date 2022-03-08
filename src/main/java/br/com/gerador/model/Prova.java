package br.com.gerador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Prova {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message="Campo Obrigatório")
	private String tituloProva;
	
	@NotNull(message="Campo Obrigatório")
	private Integer quantidadeQuestoes;

	public Prova() {}

	public Prova(@NotBlank String tituloProva, @NotBlank Integer quantidadeQuestoes) {
		super();
		this.tituloProva = tituloProva;
		this.quantidadeQuestoes = quantidadeQuestoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTituloProva() {
		return tituloProva;
	}

	public void setTituloProva(String tituloProva) {
		this.tituloProva = tituloProva;
	}

	public Integer getQuantidadeQuestoes() {
		return quantidadeQuestoes;
	}

	public void setQuantidadeQuestoes(Integer quantidadeQuestoes) {
		this.quantidadeQuestoes = quantidadeQuestoes;
	}
	
	
}
