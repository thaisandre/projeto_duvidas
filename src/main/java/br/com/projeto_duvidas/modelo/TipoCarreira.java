package br.com.projeto_duvidas.modelo;

public enum TipoCarreira {
	
	PROGRAMACAO ("programação"),
	MOBILE ("mobile"),
	FRONT_END ("front-end"),
	INFRAESTRUTURA ("infraestrutura"),
	DESIGN_AND_UX ("design & UX"),
	BUSINESS ("businness");
	
	private String nome;
	
	TipoCarreira(String nome){
		this.nome = nome;
	}
	
	public String getValue(){
		return name();
	}
	
	public void setValue(){
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}
