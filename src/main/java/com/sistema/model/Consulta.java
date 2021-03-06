package com.sistema.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.sistema.enums.StatusConsulta;
import com.sistema.enums.TipoConsulta;

@Entity
public class Consulta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Medico medico;
	private Paciente paciente;
	private Date data;
	private String informacoes;
	private String detalhes;	
	private TipoConsulta tipoConsulta;
	private StatusConsulta statusConsulta;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@NotNull
	@ManyToOne
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	@NotNull
	@ManyToOne
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	@NotNull
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	@Column(length=380)
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}	
	
	@NotNull
	@Column(name="tipo_consulta", length=20)
	@Enumerated(EnumType.STRING)
	public TipoConsulta getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(TipoConsulta tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
		
	@Column(name="status", length=20)
	@Enumerated(EnumType.STRING)
	public StatusConsulta getStatusConsulta() {
		return statusConsulta;
	}
	public void setStatusConsulta(StatusConsulta statusConsulta) {
		this.statusConsulta = statusConsulta;
	}
	
	@Transient
	public boolean getFinalizada(){
		if (getStatusConsulta() == StatusConsulta.FINALIZADA){
			return true;
		}
		return false;
	}
	
	@Column(length=380)
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (id != other.id)
			return false;
		return true;
	}	
	
}
