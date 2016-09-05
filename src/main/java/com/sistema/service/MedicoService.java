package com.sistema.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sistema.model.Medico;
import com.sistema.repository.Medicos;
import com.sistema.util.jpa.Transactional;

public class MedicoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Medicos medicos;
	
	@Transactional
	public void salvar(Medico medico) throws NegocioException{
		Medico med = medicos.porCRM(medico.getCrm());
		
		if (med != null){
			throw new NegocioException("Já existe um médico com o CRM informado.");
		}
		medicos.guardar(medico);
	}
}
