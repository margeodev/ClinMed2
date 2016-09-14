package com.sistema.enums;

public enum StatusConsulta {
	ABERTA("Aberta"), 
	ATENDIMENTO("Atendimento"), 
	FINALIZADA("Finalizada");
	
	private String descricao;
	
	StatusConsulta(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	
}
