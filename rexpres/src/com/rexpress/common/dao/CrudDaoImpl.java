package com.rexpress.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public abstract class CrudDaoImpl<ENTITY, PK> implements CrudDao<ENTITY, PK>  {

	/** 
	 * 
	 * **/
	protected abstract EntityManager getEntityManager() ;
	
	/**
	 * delega la conececcion a gestor de sesiones de hibernate
	 * 
	 * **/
	protected abstract Session getSessionManager() ;
	
	/**
	 * metodo de la interface implementadao 
	 * convertida abract para gestinarla en la implementacion common
	 * **/
	public abstract Class<ENTITY> getDaoTypeClass();
	
	
	/**
	 * API JPA RESOLVE QUERY NAMEDQUERY
	 * **/
	
	protected Query createNamedQuery(String namedQuery) {
		return getEntityManager().createNamedQuery(namedQuery);
	}

	protected Query createNamedQuery(String namedQuery ,Class<ENTITY> clase) {
		return getEntityManager().createNamedQuery(namedQuery,clase);
	}
	
	protected Query createSimpleParameterNamedQuery(String namedQuery ,Class<ENTITY> clase , String parameter , String value) {
		return getEntityManager().createNamedQuery(namedQuery,clase).setParameter(parameter, value);
	}
	
	/**
	 * API JPA RESOLVE QUERY CREATEQUERY 
	 * 
	 * **/
	protected Query createQuery(String quey){
		return getEntityManager().createQuery(quey);
	}
	
	protected Query createQuery(String quey, Class<ENTITY> clase){
		return getEntityManager().createQuery(quey,clase);
	}
	
	protected Query createSimpleParameterQuery(String quey , String parameter, String value){
		return getEntityManager().createQuery(quey).setParameter(parameter, value);
	}
	
	
	/** 
	 *
	 * api JPA API RESOLVE NATIVE QUERY
	 * */
	protected Query createNativeQuery(String query) {
		
		return getEntityManager().createNativeQuery(query);
	}
	
	protected Query createNativeQuery(String query , Class<ENTITY> clase ) {
		return getEntityManager().createNativeQuery(query, clase);
				
	}

	/**
	 * @author Edison Zamora
	 * AP HIBERNATE SESSION RESOLVE NAMED QUERY
	 **/
	protected Query createHQLNamedQuery(String query) {
		return getSessionManager().getNamedQuery(query);
	}
	
	protected Query createHQLNamedQuery2(String query,String parameter, String value) {
		return getSessionManager().getNamedQuery(query).setParameter(parameter, value);
	}
	
	protected Query createHQLNamedQuery(String query, Class<ENTITY> clase) {
		return getSessionManager().createNamedQuery(query,clase);
	}
	
	protected Query createSimpleParameterHQLNamedQuery(String query, String parameter, String value) {
		return getSessionManager().createNamedQuery(query).setParameter(parameter, value);
	}
	
	protected Query createHQLQuery(String query , Class<ENTITY> clase) {
		return getSessionManager().createQuery(query,clase );
	}
	
	protected Query createSimpleParameterHQLQuery(String query ,String parameter, String value) {
		return getSessionManager().createQuery(query).setParameter(parameter, value);
	}
	
	protected void create(ENTITY valor)throws IllegalStateException {
			    EntityManager ent = getEntityManager();
				ent.getTransaction().begin();
				ent.persist(valor);
				ent.getTransaction().commit();
				ent.close();	 
	}
}
