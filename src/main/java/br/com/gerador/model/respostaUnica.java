package br.com.gerador.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class respostaUnica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRespostaUnica;
	
	@Column
	private String alternativa1;
	
	/*@Column
	private boolean valida1;*/
	
	@Column
	private String alternativa2;
	
	/*@Column
	private boolean valida2;*/
	
	@Column
	private String alternativa3;
	
	/*@Column
	private boolean valida3;*/
	
	@Column
	private String alternativa4;
	
	/*@Column
	private boolean valida4;*/
	
	@Column
	private String alternativa5;
	
	/*@Column
	private boolean valida5;*/
	
	@Column
	@Enumerated(value = EnumType.STRING)
	private questaoCorreta questaoCorreta;
	
	@OneToOne
	private Questao questao;
	
	//Getters and Setters

	public Long getIdRespostaUnica() {
		return idRespostaUnica;
	}

	public void setIdRespostaUnica(Long idRespostaUnica) {
		this.idRespostaUnica = idRespostaUnica;
	}

	public String getAlternativa1() {
		return alternativa1;
	}

	public void setAlternativa1(String alternativa1) {
		this.alternativa1 = alternativa1;
	}

	

	public String getAlternativa2() {
		return alternativa2;
	}

	public void setAlternativa2(String alternativa2) {
		this.alternativa2 = alternativa2;
	}



	public String getAlternativa3() {
		return alternativa3;
	}

	public void setAlternativa3(String alternativa3) {
		this.alternativa3 = alternativa3;
	}

	

	public String getAlternativa4() {
		return alternativa4;
	}

	public void setAlternativa4(String alternativa4) {
		this.alternativa4 = alternativa4;
	}

	

	public String getAlternativa5() {
		return alternativa5;
	}

	public void setAlternativa5(String alternativa5) {
		this.alternativa5 = alternativa5;
	}

	

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public questaoCorreta getQuestaoCorreta() {
		return questaoCorreta;
	}

	public void setQuestaoCorreta(questaoCorreta questaoCorreta) {
		this.questaoCorreta = questaoCorreta;
	}

	
	
}
