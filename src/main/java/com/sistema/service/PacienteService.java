package com.sistema.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sistema.model.Paciente;
import com.sistema.repository.Pacientes;
import com.sistema.util.jpa.Transactional;

public class PacienteService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Pacientes pacientes;
	
	@Transactional
	public void salvar(Paciente paciente) throws NegocioException{
		Paciente pacTemp = pacientes.porCPF(paciente.getCpf());
		
		if (pacTemp != null){
			throw new NegocioException("Já existe um paciente com o CPF informado");
		} 			
				
//		if (!ValidaCpf.isValidCPF(paciente.getCpf())){
//			throw new NegocioException("CPF inválido");
//		}		
		pacientes.guardar(paciente);		
	}
}
