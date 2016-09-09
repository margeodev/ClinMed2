package com.sistema.controller.pacientes;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.model.Medico;
import com.sistema.model.Paciente;
import com.sistema.repository.Pacientes;
import com.sistema.repository.filter.MedicoFilter;
import com.sistema.repository.filter.PacienteFilter;

@Named
@ViewScoped
public class PesquisarPacientesBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pacientes pacientesRep;
	
	private List<Paciente> pacientes;
	private PacienteFilter pacFilter; 
	
	@PostConstruct
	public void init(){
		pacFilter = new PacienteFilter();
		pacientes = pacientesRep.todos();
	}
		
	public void pesquisar(){		
		pacientes = pacientesRep.filtrar(pacFilter);
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public PacienteFilter getPacFilter() {
		return pacFilter;
	}
	
	public boolean isTipoMedico(){
		return false;
	}
}
