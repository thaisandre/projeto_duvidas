package br.com.projeto_duvidas.modelo;

public enum TipoFerramenta {
	
	BANCO_DE_DADOS ("banco de dados"),
	LINGUAGEM_DE_PROGRAMACAO ("linguagem de programação"),
	LINGUAGEM_DE_MARCACAO ("linguagem de marcação"),
	FRAMEWORK ("framework"),
	BIBLIOTECA ("biblioteca"),
	API ("API"),
	VERSIONAMENTO ("ferramenta de versionamento"),
	BUILD ("ferramenta de build");
	
	private String nome;
	
	TipoFerramenta(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
}
