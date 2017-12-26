package br.com.projeto_duvidas.modelo;

public enum TipoFerramenta {
	
	BANCO_DE_DADOS ("banco de dados"),
	LINGUAGEM_DE_PROGRAMACAO ("linguagem de programação"),
	LINGUAGEM_DE_MARCACAO ("linguagem de marcação"),
	FRAMEWORK ("framework"),
	BIBLIOTECA ("biblioteca"),
	API ("API"),
	VERSIONAMENTO ("ferramenta de versionamento"),
	BUILD ("ferramenta de build"),
	FOLHA_DE_ESTILO ("folha de estilo"),
	PROTOCOLO ("protocolo"),
	OUTROS ("outros");
	
	private String nome;
	
	TipoFerramenta(String nome){
		this.nome = nome;
	}
	
	public String getValue(){
		return name();
	}
	
	public void setValue() {}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
