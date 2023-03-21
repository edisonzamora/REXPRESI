package com.rexpress.services.configoptions;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rexpress.to.ConfigOptionsTo;

@Service
public interface ConfigOptionsService  {

	List<ConfigOptionsTo> allConfigOrtions();
		
	
}
