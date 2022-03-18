package br.com.gerador.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Questao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idQuestao;
	
	@Column
	@Enumerated(value = EnumType.STRING)
	private tipoQuestao tipoQuestao;
	
	@Column
	@Enumerated(value = EnumType.STRING)
	private indiceDificuldade indiceDificuldade;
	
	
	@Column( nullable = false)
	@NotBlank(message="Campo Obrigatório")
	private String descricao;
	

	/*
	 * iNCLUINDO TAG
	@ManyToOne
	@JoinColumn(name="ID_TAG")
	private Tag tag;
	*/
	
	@Column
	@Enumerated(value = EnumType.STRING)
	private Tag tag;
	

	public Questao() {}

	public Questao(Long idQuestao,  tipoQuestao tipoQuestao, indiceDificuldade indiceDificuldade, String descricao, Tag tag) {
		super();
		this.idQuestao = idQuestao;
		this.tipoQuestao = tipoQuestao;
		this.indiceDificuldade = indiceDificuldade;
		this.descricao = descricao;
		this.tag = tag;
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

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Questao [idQuestao=" + idQuestao + ", tipoQuestao=" + tipoQuestao + ", indiceDificuldade="
				+ indiceDificuldade + ", descricao=" + descricao + ", tag=" + tag + "]";
	}
	
	
	
}
