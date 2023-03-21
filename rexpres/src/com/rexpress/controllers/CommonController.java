package com.rexpress.controllers;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;

import com.config.AbstractController;

public class CommonController extends AbstractController {
	
	private FacesContext facesContext;
	
	private Logger logger;
	
	@Override
	public FacesContext getFacesContext() {
	    facesContext=FacesContext.getCurrentInstance();
		return facesContext;
	}

	@Override
	protected Logger getLoger() {
		logger= LogManager.getLogger(this);
			return logger;
		}
	protected String getParameter(String name){
		FacesContext fc  = getFacesContext();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		 return  params.get(name);
	}
	
	protected void enviarMensaje(Severity tipo, String titulo , String mensaje) {
		   FacesMessage message = new FacesMessage(tipo,titulo, mensaje);
	        PrimeFaces.current().dialog().showMessageDynamic(message);
		
	}
}
	

