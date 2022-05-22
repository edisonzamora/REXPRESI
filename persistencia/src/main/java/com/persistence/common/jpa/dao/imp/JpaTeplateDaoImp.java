package com.persistence.common.jpa.dao.imp;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;

public abstract class JpaTeplateDaoImp <T> extends JpaCommonDaoImp{

	@PersistenceContext
	public EntityManager ent;
	
	public JpaTeplateDaoImp() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public EntityManager getEntiyManager() {
		// TODO Auto-generated method stub
		return ent;
	}

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return (Session)ent.getDelegate();
	}
//	@Override
//	public EntityManager getEntiyManager() {
//		// TODO Auto-generated method stub
//		return super.getJpaTemplate().getEntityManager();
//	}
//
//	@Override
//	protected Session getSession() {
//		// TODO Auto-generated method stub
//	Session  session=(Session)	getEntiyManager().getDelegate();
//	
//		return session;
//	}
	/**
	 * @author Edison Zamora
	 * @param namedQuery  namedQuery definida en la entity
	 * @param key llave :example definida en la query
	 * @param K valor a enviar
	 * @return objeto definido en T
	 * **/
	protected T getFineByNamedQuery(String namedQuery , String key , Object value){
		
		T object= (T) createNamedQuery(namedQuery)
				.setParameter(key, value)
				.getSingleResult();
		return object ;
	}
	
   protected List<T> getFineByNamedQueryList(String namedQuery , String key , Object value){
		
		List<T> object= (List<T>) createNamedQuery(namedQuery)
				.setParameter(key, value)
				.getResultList();
		return object ;
	}

}
