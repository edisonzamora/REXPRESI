package com.rexpress.services.configoptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rexpress.common.service.CommonServices;
import com.rexpress.dao.ConfigOptionsDao;
import com.rexpress.entities.ConfigOptions;
import com.rexpress.to.ConfigOptionsTo;

@Service
public class ConfigOptionsServiceImpl extends CommonServices<ConfigOptionsTo, ConfigOptions> implements ConfigOptionsService{

	@Autowired
	private ConfigOptionsDao configOptionsDao;
	
	public ConfigOptionsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ConfigOptionsTo> allConfigOrtions() {
		// TODO Auto-generated method stub
		
		List<ConfigOptions> list=(List<ConfigOptions>) configOptionsDao.getAllConfigOptions("listaOpciones");
		List<ConfigOptionsTo> listTo= converteModelListforToList(list);
	
		
		return listTo;
	}
	
	


	private   ConfigOptionsTo converteModelforTo(ConfigOptions model) {
		ConfigOptionsTo confOTo=new ConfigOptionsTo();
		confOTo.setNombre(model.getNombre());
		confOTo.setValor(model.getValor());
		confOTo.setActivo(Integer.toString( model.getActivo()));
		return confOTo;
	}

	private  List<ConfigOptionsTo> converteModelListforToList(List<ConfigOptions> model) {
		// TODO Auto-generated method stub
		List<ConfigOptionsTo> listTo= new ArrayList<ConfigOptionsTo>();
		for (ConfigOptions configOption : model) {
			listTo.add(converteModelforTo(configOption));
		}
		return listTo;
	}
	
	
}
