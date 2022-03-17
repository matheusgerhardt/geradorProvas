package br.com.gerador.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Questao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idQuestao;
	
	private tipoQuestao tipoQuestao;
	
	private indiceDificuldade indiceDificuldade;
	
	@NotBlank(message="Campo Obrigatório")
	private String descricao;

	public Questao() {}

	public Questao(Long idQuestao, br.com.gerador.model.tipoQuestao tipoQuestao,
			br.com.gerador.model.indiceDificuldade indiceDificuldade,
			@NotBlank(message = "Campo Obrigatório") String descricao) {
		super();
		this.idQuestao = idQuestao;
		this.tipoQuestao = tipoQuestao;
		this.indiceDificuldade = indiceDificuldade;
		this.descricao = descricao;
	}

	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
	}

	public tipoQuestao getTipoQuestao() {
		return tipoQuestao;
	}

	public void setTipoQuestao(tipoQuestao tipoQuestao) {
		this.tipoQuestao = tipoQuestao;
	}

	public indiceDificuldade getIndiceDificuldade() {
		return indiceDificuldade;
	}

	public void setIndiceDificuldade(indiceDificuldade indiceDificuldade) {
		this.indiceDificuldade = indiceDificuldade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
