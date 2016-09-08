package com.sistema.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Medico {
	private int id;
	private String nome;
	private String crm;
	private String telefone1;
	private String telefone2;
	private Endereco endereco;
	private List<Especialidade> especialidades;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@NotEmpty
	@Column(length=60, nullable=false)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotEmpty
	@Column(length=15, nullable=false, unique=true)
	public String getCrm() {
		return crm;
	}
	
	public void setCrm(String crm) {
		this.crm = crm;
	}
		
	@NotEmpty
	@Column(length=15, nullable=false)
	public String getTelefone1() {
		return telefone1;
	}
	
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	
	@Column(length=15)
	public String getTelefone2() {
		return telefone2;
	}
	
	@Column(length=15)
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id_endereco")
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}		
	
	@ManyToMany
	public List<Especialidade> getEspecialidade() {
		return especialidades;
	}
	
	public void setEspecialidade(List<Especialidade> especialidade) {
		this.especialidades = especialidade;
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
		Medico other = (Medico) obj;
		if (id != other.id)
			return false;
		return true;
	}	
	
}
