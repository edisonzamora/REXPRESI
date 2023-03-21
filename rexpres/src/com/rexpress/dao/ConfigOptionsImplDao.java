package com.rexpress.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rexpress.common.dao.CommonDaoImpl;
import com.rexpress.entities.ConfigOptions;

@Repository
public class ConfigOptionsImplDao extends CommonDaoImpl<ConfigOptions, Integer> implements ConfigOptionsDao{

	public ConfigOptionsImplDao() {
		// TODO Auto-generated constructor stub
		
		
	}

	@Override
	public Class<ConfigOptions> getDaoTypeClass() {
		// TODO Auto-generated method stub
		return ConfigOptions.class;
	}

	@Override
	public List<ConfigOptions> getAllConfigOptions(String query) {
		// TODO Auto-generated method stub
		List list=	getSessionManager().createNamedQuery(query, ConfigOptions.class).getResultList();
		return list;
	}
	
	
	

}
