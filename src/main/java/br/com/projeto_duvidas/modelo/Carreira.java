package br.com.projeto_duvidas.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Carreira {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String nomeAbreviado;

	private String link;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Enumerated(EnumType.STRING)
	private TipoCarreira tipo;

	@ManyToMany
	private List<Ferramenta> ferramentas;

	@ManyToMany
	private List<Curso> cursos;

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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getNomeAbreviado() {
		return nomeAbreviado;
	}

	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}

	public List<Ferramenta> getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(List<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}

	public TipoCarreira getTipo() {
		return tipo;
	}

	public void setTipo(TipoCarreira tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return nome;
	}
}
