package com.sistema.repository.filter;

import java.io.Serializable;
import java.util.Date;

public class ConsultaFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String medicoNome;
	private String pacienteNome;
	private Date dataConsulta;	
	
	public String getMedicoNome() {
		return medicoNome;
	}
	public void setMedicoNome(String medicoNome) {
		this.medicoNome = medicoNome;
	}
	public String getPacienteNome() {
		return pacienteNome;
	}
	public void setPacienteNome(String pacienteNome) {
		this.pacienteNome = pacienteNome;
	}
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
}
