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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="questoes")
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
	
	/*
	 * iNCLUINDO TAG
	@ManyToOne
	@JoinColumn(name="ID_TAG")
	private Tag tag;
	*/
	
	@Column
	@Enumerated(value = EnumType.STRING)
	private Tag tag;
	
	@Column(nullable = false)
	@NotBlank(message="Campo Obrigatório")
	private String descricao;
	
	
	// ULTILIZAÇÃO STRATATEGY PARA MAPEAMENTO DOS TIPOS DE PERGUNTA/RESPOSTA
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_RESPOSTAABERTA", referencedColumnName= "idRespostaAberta")
	private respostaAberta respostaAberta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_RESPOSTAUNICA", referencedColumnName= "idRespostaUnica")
	private respostaUnica respostaUnica;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_RESPOSTAMULTIPLA", referencedColumnName= "idRespostaMultipla")
	private respostaMultipla respostaMultipla;
	
	
	//Getters and Setters
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

	public respostaAberta getRespostaAberta() {
		return respostaAberta;
	}

	public void setRespostaAberta(respostaAberta respostaAberta) {
		this.respostaAberta = respostaAberta;
	}

	public respostaUnica getRespostaUnica() {
		return respostaUnica;
	}

	public void setRespostaUnica(respostaUnica respostaUnica) {
		this.respostaUnica = respostaUnica;
	}

	public respostaMultipla getRespostaMultipla() {
		return respostaMultipla;
	}

	public void setRespostaMultipla(respostaMultipla respostaMultipla) {
		this.respostaMultipla = respostaMultipla;
	}
	
	
	//Construtores
	
	public Questao() {}
	
	//Construtor sem Resposta
	public Questao(Long idQuestao,  tipoQuestao tipoQuestao, indiceDificuldade indiceDificuldade, String descricao, Tag tag) {
		super();
		this.idQuestao = idQuestao;
		this.tipoQuestao = tipoQuestao;
		this.indiceDificuldade = indiceDificuldade;
		this.descricao = descricao;
		this.tag = tag;
	}
	
	//Construtor Resposta Aberta
	public Questao(Long idQuestao,  tipoQuestao tipoQuestao, indiceDificuldade indiceDificuldade, String descricao, Tag tag, respostaAberta respostaAberta) {
		super();
		this.idQuestao = idQuestao;
		this.tipoQuestao = tipoQuestao;
		this.indiceDificuldade = indiceDificuldade;
		this.descricao = descricao;
		this.tag = tag;
	}
	
	//Construtor Resposta Unica
	public Questao(Long idQuestao,  tipoQuestao tipoQuestao, indiceDificuldade indiceDificuldade, String descricao, Tag tag, respostaUnica respostaUnica) {
		super();
		this.idQuestao = idQuestao;
		this.tipoQuestao = tipoQuestao;
		this.indiceDificuldade = indiceDificuldade;
		this.descricao = descricao;
		this.tag = tag;
	}
	
	//Construtor Resposta Multipla
	public Questao(Long idQuestao,  tipoQuestao tipoQuestao, indiceDificuldade indiceDificuldade, String descricao, Tag tag, respostaMultipla respostaMultipla) {
		super();
		this.idQuestao = idQuestao;
		this.tipoQuestao = tipoQuestao;
		this.indiceDificuldade = indiceDificuldade;
		this.descricao = descricao;
		this.tag = tag;
	}
	

	
	
	
}
