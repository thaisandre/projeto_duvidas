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
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String nomeAbreviado;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	private String link;

	@Enumerated(EnumType.STRING)
	private TipoCurso categoria;

	@ManyToMany
	private List<Curso> cursos;

	@ManyToMany
	private List<Carreira> carreiras;

	@ManyToMany
	private List<Ferramenta> ferramentas;

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

	public String getNomeAbreviado() {
		return nomeAbreviado;
	}

	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Carreira> getCarreiras() {
		return carreiras;
	}

	public void setCarreiras(List<Carreira> carreiras) {
		this.carreiras = carreiras;
	}

	public TipoCurso getCategoria() {
		return categoria;
	}

	public void setCategoria(TipoCurso categoria) {
		this.categoria = categoria;
	}

	public List<Ferramenta> getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(List<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}
	
	@Override
	public String toString() {
		return nome;
	}

}
