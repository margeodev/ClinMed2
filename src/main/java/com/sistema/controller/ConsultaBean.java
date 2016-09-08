package com.sistema.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.enums.TipoConsulta;
import com.sistema.model.Consulta;
import com.sistema.model.Medico;
import com.sistema.model.Paciente;
import com.sistema.repository.Medicos;
import com.sistema.repository.Pacientes;
import com.sistema.service.ConsultaService;
import com.sistema.service.NegocioException;
import com.sistema.util.jsf.FacesUtil;

@Named
@ViewScoped
public class ConsultaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private Pacientes pacRep;	
	@Inject
	private Medicos medRep;
	@Inject
	private ConsultaService consultaService;
	
	private List<Paciente> pacientes;
	private List<Medico> medicos;
	private Consulta consulta;			
	
	@PostConstruct
	public void init(){
		medicos = medRep.todos();
		pacientes = pacRep.todos();				
		consulta = new Consulta();
	}
	
	public void salvar(){
		try {
			consultaService.salvar(consulta);
			limpar();
			FacesUtil.addSuccessMessage("Consulta registrada com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	private void limpar() {
		this.consulta = new Consulta();		
	}

	public TipoConsulta[] getTipoConsulta(){
		return TipoConsulta.values();
	}
	
	public List<Paciente> escolherPaciente(String input) {
        List<Paciente> pacSugeridos = new ArrayList<>();        
        for (Paciente pac : pacientes) {
            if (pac.getNome().toLowerCase().startsWith(input.toLowerCase())) {
            	pacSugeridos.add(pac);
            }
        }               
        return pacSugeridos;
	}	
	
	public List<Medico> escolherMedico(String input) {
		List<Medico> medSugeridos = new ArrayList<>();        
		for (Medico med : medicos) {
			if (med.getNome().toLowerCase().startsWith(input.toLowerCase())) {
				medSugeridos.add(med);
			}
		}               
		return medSugeridos;
	}	
	
	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
}
