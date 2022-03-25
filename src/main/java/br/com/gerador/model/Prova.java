package br.com.gerador.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name="ID_QUESTAO", referencedColumnName= "idQuestao")
	@JoinTable(
	        name = "prova_questao",
	        joinColumns = @JoinColumn(name = "idProva"),
	        inverseJoinColumns = @JoinColumn(name = "idQuestao")
	    )
	Set<Questao> questoes = new HashSet<>();

	public Prova() {}

	public Prova(Long id, @NotBlank(message = "Campo Obrigatório") String tituloProva,
			@NotNull(message = "Campo Obrigatório") Integer quantidadeQuestoes, Set<Questao> questoes) {
		super();
		this.id = id;
		this.tituloProva = tituloProva;
		this.quantidadeQuestoes = quantidadeQuestoes;
		this.questoes = questoes;
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

	public Set<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Set<Questao> questoes) {
		this.questoes = questoes;
	}
		
}
