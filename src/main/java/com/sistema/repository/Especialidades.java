package com.sistema.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sistema.model.Especialidade;

public class Especialidades implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public List<Especialidade> especialidades(){
		return em.createQuery("from Especialidade", Especialidade.class).getResultList();
	}

	public Especialidade porId(int id) {
		return em.find(Especialidade.class, id);
	}
	
}
