package com.rexpress.dao;

import java.util.List;

import com.rexpress.common.dao.CrudDao;
import com.rexpress.entities.ConfigOptions;

public interface ConfigOptionsDao extends CrudDao<ConfigOptions,Integer >{

     List<?> getAllConfigOptions(String query );
	
}
