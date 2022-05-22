package com.persistence.rexpres.jpa.dao.imp;

import java.util.List;

import com.persistence.common.jpa.dao.imp.JpaTeplateDaoImp;
import com.persistence.entities.Estado;
import com.persistence.rexpres.jpa.dao.EstadoDao;

public class EstadoDaoImp extends JpaTeplateDaoImp<Estado> implements EstadoDao {

	public EstadoDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Estado buscarPorIdNamedQuery(String namedQuery, String K, Integer Value) {
		// TODO Auto-generated method stub
		return getFineByNamedQuery(namedQuery, K, Value);
	}

	@Override
	public List<Estado> buscarPorNombreNamedQuery(String namedQuery, String K, String Value) {
		// TODO Auto-generated method stub
		return getFineByNamedQueryList(namedQuery, K, Value);
	}


}
