package com.rexpress.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.stereotype.Repository;


@Repository
public abstract class CommonDaoImpl<ENTITY, PK> extends CrudDaoImpl<ENTITY, PK>{

	private static final Logger logger = LogManager.getLogger(CommonDaoImpl.class);

	private static EntityManagerFactory emfTest;
	private static EntityManagerFactory emfRex;
	
	private static EntityManager em;

	static {
		try {
			logger.info("emf=Persistence.createEntityManagerFactory(testPU);");

			emfTest = Persistence.createEntityManagerFactory("testPU");
			
		} catch (PersistenceException e) {
			
			logger.error(e.getMessage());
			logger.error(e.getCause());

		} finally {
			logger.info("Controlando coneccion");
		}
		try {
			logger.info("emf=Persistence.createEntityManagerFactory(rexpressPU);");

			emfRex=Persistence.createEntityManagerFactory("rexpressPU");
		} catch (PersistenceException e) {
			
			logger.error(e.getMessage());
			logger.error(e.getCause());

		} finally {
			logger.info("Controlando coneccion");
		}
		// SET GLOBAL time_zone = '-3:00';//
	}

	@Override
	protected EntityManager getEntityManager() throws IllegalStateException{
		EntityManager em = emfTest.createEntityManager();
		return em;
	}
	
	@Override
	
	protected Session getSessionManager() throws IllegalStateException {
		// TODO Auto-generated method stub
		
//		SessionImplementor sessionImplementor = getEntityManager().unwrap( SessionImplementor.class );
//		SessionFactory sessionFactory = getEntityManager().getEntityManagerFactory().unwrap( SessionFactory.class );
		EntityManager em=emfRex.createEntityManager();	
		return em.unwrap(Session.class);
		 
	}

}
