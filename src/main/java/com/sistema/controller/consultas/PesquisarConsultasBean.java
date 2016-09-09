package com.sistema.controller.consultas;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sistema.model.Consulta;
import com.sistema.repository.Consultas;
import com.sistema.repository.filter.ConsultaFilter;
import com.sistema.repository.filter.MedicoFilter;

@Named
@ViewScoped
public class PesquisarConsultasBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Consultas consultasRep;
	
	private List<Consulta> consultas;
	private ConsultaFilter consultaFilter = new ConsultaFilter();
	
	@PostConstruct
	public void init(){
		consultas = consultasRep.todas();
	}

	public void pesquisar(){		
		consultas = consultasRep.filtrar(consultaFilter);
	}
	
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public ConsultaFilter getConsultaFilter() {
		return consultaFilter;
	}
			
}
