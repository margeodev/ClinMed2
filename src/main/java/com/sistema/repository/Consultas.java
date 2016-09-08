package com.sistema.repository;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.sistema.model.Consulta;

public class Consultas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void guardar(Consulta consulta){
		em.merge(consulta);
	}
	
	public List<Consulta> todas() {
		return em.createQuery("from Consulta", Consulta.class).getResultList();
	}

}