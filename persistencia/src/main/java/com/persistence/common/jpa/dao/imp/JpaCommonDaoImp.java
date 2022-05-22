package com.persistence.common.jpa.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.orm.jpa.support.JpaDaoSupport;

public abstract class JpaCommonDaoImp extends JpaDaoSupport {

	public abstract EntityManager getEntiyManager();

	public abstract Session getSession();

	public JpaCommonDaoImp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Edison Zamora
	 * @param query
	 *            elaborada dentro de la entity
	 * @return Objeto Query
	 **/
	public Query createNamedQuery(String named) {

		return getEntiyManager().createNamedQuery(named);

	}

	protected Query createNativeQuery(String query, Class<?> t) {

		return getEntiyManager().createNativeQuery(query, t);

	}
	

	protected Query createNativeQuery(String query) {

		return getEntiyManager().createNativeQuery(query);

	}

}
