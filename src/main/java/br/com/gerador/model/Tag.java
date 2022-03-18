package br.com.gerador.model;

public enum Tag {
	MATEMATICA, 
	FISICA, 
	HISTORIA,
	GEOGRAFIA, 
	QUIMICA,
	PORTUGUES,
	INGLES
}


/*
 * TAG COMO ENTIDADE
 * 
@Entity
public class Tag implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message="Campo Obrigatório")
	@Column(length = 50, nullable = false, unique = true)
	private String nome;
	
	@OneToMany
	@JoinColumn
	private List <Questao> questoes;
	
	public Tag() { }
	
	public Tag(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestao(List<Questao> questoes) {
		this.questoes = questoes;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", nome=" + nome + "]";
	}
		
}
*/
	
	
