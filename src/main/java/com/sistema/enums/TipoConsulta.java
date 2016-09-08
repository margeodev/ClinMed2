package com.sistema.enums;

public enum TipoConsulta {
	NOVA_CONSULTA("Nova Consulta"), RETORNO("Retorno");
	
	private String descricao;
	
	TipoConsulta(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
}
