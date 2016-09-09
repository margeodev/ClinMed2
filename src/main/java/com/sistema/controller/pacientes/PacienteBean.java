package com.sistema.controller.pacientes;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.model.Endereco;
import com.sistema.model.Paciente;
import com.sistema.repository.EnderecoPorCep;
import com.sistema.service.NegocioException;
import com.sistema.service.PacienteService;
import com.sistema.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PacienteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private PacienteService pacienteService;		
	@Inject
	private EnderecoPorCep endCep;
	private Paciente paciente;
	
	public void adicionar() {
		try {
			pacienteService.salvar(paciente);
			limpar();
			FacesUtil.addSuccessMessage("Paciente adicionado com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}				
	}
	
	public void fillAddress() {
		paciente.setEndereco(endCep.obterEndereco(paciente.getEndereco().getCep()));
	}
	
	@PostConstruct
	public void init(){
		limpar();
	}
	public void limpar(){
		paciente = new Paciente();		
		paciente.setEndereco(new Endereco());
	}		
		
	public Date getDataHoje(){
		return new Date(); 
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public boolean isTipoMedico(){
		return false;
	}
}
