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
import com.sistema.model.Medico;
import com.sistema.repository.filter.MedicoFilter;

public class Medicos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private EntityManager em;
	
	public void guardar(Medico medico) {
		em.merge(medico);			
	}

	public Medico porCRM(String crm) {
		try {
			return em.createQuery("from Medico where crm = :crm", Medico.class)
				.setParameter("crm", crm).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> filtrar(MedicoFilter filtro){
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Medico.class);
		
		if (StringUtils.isNotBlank(filtro.getCrm())){
			criteria.add(Restrictions.eq("crm", filtro.getCrm()));
		}
		if (StringUtils.isNotBlank(filtro.getNome())){
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(filtro.getEspecialidade())){
			criteria.createAlias("especialidade", "e");
			criteria.add(Restrictions.ilike("e.descricao", filtro.getEspecialidade(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}

	public List<Medico> todos() {
		return em.createQuery("from Medico", Medico.class).getResultList();
	}

	public Medico porId(int id) {
		return em.find(Medico.class, id);
	}
	
}
