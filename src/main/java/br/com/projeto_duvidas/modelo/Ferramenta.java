package br.com.projeto_duvidas.modelo;

public class Ferramenta {

	private Long id;
	private String nome;
	private String descricao;
	private TipoFerramenta tipo;
	
	public Ferramenta() {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoFerramenta getTipo() {
		return tipo;
	}

	public void setTipo(TipoFerramenta tipo) {
		this.tipo = tipo;
	}

}
