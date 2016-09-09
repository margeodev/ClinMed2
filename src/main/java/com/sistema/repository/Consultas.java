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
	
	@SuppressWarnings("unchecked")
	public List<Consulta> filtrar(ConsultaFilter filtro){
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Consulta.class)
			.createAlias("medico", "m")
			.createAlias("paciente", "p");
		
		if (StringUtils.isNotBlank(filtro.getMedicoNome())){
			criteria.add(Restrictions.ilike("m.nome", filtro.getMedicoNome(), MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(filtro.getPacienteNome())){
			criteria.add(Restrictions.ilike("p.nome", filtro.getPacienteNome(), MatchMode.ANYWHERE));
		}
		if (filtro.getDataConsulta() != null){
			System.out.println(filtro.getDataConsulta());
			criteria.add(Restrictions.eq("data", filtro.getDataConsulta()));
		}
		
		return criteria.addOrder(Order.asc("id")).list();
	}
	
}