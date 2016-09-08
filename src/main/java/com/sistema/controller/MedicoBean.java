package com.sistema.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.model.Endereco;
import com.sistema.model.Especialidade;
import com.sistema.model.Medico;
import com.sistema.repository.EnderecoPorCep;
import com.sistema.repository.Especialidades;
import com.sistema.service.MedicoService;
import com.sistema.service.NegocioException;
import com.sistema.util.jsf.FacesUtil;

@Named
@ViewScoped
public class MedicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private MedicoService medServ;
	@Inject
	private Especialidades espRep;	
	@Inject
	private EnderecoPorCep endCep;
	private Medico medico;
	private List<Especialidade> especialidades = new ArrayList<>();	
	
	public void adicionar() {
		try {
			medServ.salvar(medico);
			limpar();
			FacesUtil.addSuccessMessage("Médico adicionado com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}				
	}
	
	public void fillAddress() {
		medico.setEndereco(endCep.obterEndereco(medico.getEndereco().getCep()));
	}
	
	@PostConstruct
	public void init(){
		limpar();
	}
	public void limpar(){
		medico = new Medico();		
		medico.setEndereco(new Endereco());
		especialidades = espRep.especialidades();
	}		
		
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}
	
	public boolean isTipoMedico(){
		return true;
	}

}
