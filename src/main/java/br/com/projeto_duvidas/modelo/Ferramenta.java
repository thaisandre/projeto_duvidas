package br.com.projeto_duvidas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ferramenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
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
	
	@Override
	public String toString() {
		return nome;
	}

}
