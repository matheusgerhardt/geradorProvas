package br.com.gerador.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="respostaaberta")
public class respostaAberta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRespostaAberta;
	

	private String campoResposta;
	
	@OneToOne
	private Questao questao;
	
	public Long getIdRespostaAberta() {
		return idRespostaAberta;
	}

	public void setIdRespostaAberta(Long idRespostaAberta) {
		this.idRespostaAberta = idRespostaAberta;
	}

	public String getCampoResposta() {
		return campoResposta;
	}

	public void setCampoResposta(String campoResposta) {
		this.campoResposta = campoResposta;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	
}
