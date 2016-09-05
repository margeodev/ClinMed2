package com.sistema.repository;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.sistema.model.Paciente;
import com.sistema.repository.filter.PacienteFilter;

public class Pacientes implements Serializable {	
	private static final long serialVersionUID = 1L;	
	@Inject 
	private EntityManager em;
	
	public void guardar(Paciente paciente) {		
		em.merge(paciente);		
	}
	
	public Paciente porCPF(String cpf){
		try {
			return em.createQuery("from Paciente where cpf = :cpf", Paciente.class)
					.setParameter("cpf", cpf).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}		
	}

	public Paciente porId(int id) {
		return em.find(Paciente.class, id);
	}
	
	public List<Paciente> todos() {
		return em.createQuery("from Paciente", Paciente.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> ultimos(){
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Paciente.class);
		return criteria.addOrder(Order.desc("id")).setMaxResults(10).list();		
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> filtrar(PacienteFilter pacFilter) {
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Paciente.class);
		
		if (StringUtils.isNotBlank(pacFilter.getCpf())){
			criteria.add(Restrictions.like("cpf", pacFilter.getCpf(), MatchMode.ANYWHERE));
		}
		
		if (StringUtils.isNotBlank(pacFilter.getNome())){
			criteria.add(Restrictions.ilike("nome", pacFilter.getNome(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}
	
}
