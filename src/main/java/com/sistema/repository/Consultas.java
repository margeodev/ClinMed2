package com.sistema.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.sistema.model.Consulta;
import com.sistema.model.Medico;
import com.sistema.repository.filter.ConsultaFilter;
import com.sistema.repository.filter.MedicoFilter;

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
	
	public List<Medico> filtrar(ConsultaFilter filtro){
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Consulta.class);
		
		if (StringUtils.isNotBlank(filtro.getMedicoNome())){
			criteria.add(Restrictions.eq("medico", filtro.getMedicoNome()));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}
	
}