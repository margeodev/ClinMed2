package com.sistema.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sistema.model.Consulta;
import com.sistema.repository.Consultas;
import com.sistema.util.jpa.Transactional;

public class ConsultaService implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Consultas consultaRep;
	
	@Transactional
	public void salvar(Consulta consulta) throws NegocioException{
		if (consulta.getMedico() != null && consulta.getData() != null &&
			consulta.getInformacoes() != null && consulta.getPaciente() !=null) {
			consultaRep.guardar(consulta);
		} else {
			throw new NegocioException("Preencha todos os campos");
		}
		
	}
	
}