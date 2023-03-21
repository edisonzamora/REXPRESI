package com.rexpress.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.rexpress.constant.BeansName;
import com.rexpress.to.ConfigOptionsTo;

@Component(BeansName.BEAN_HOMEBEAN)
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
public class HomeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier(value="usuarioSession")
	private UserBean userBeanHome;

	private String buscador;
	
	private String selectCamp;
	
	private ArrayList<UserBean> listaUsuariosBean;
	
	private ArrayList<ConfigOptionsTo> listaConfigOptions;
	

	public String getSelectCamp() {
		return selectCamp;
	}

	public void setSelectCamp(String selectCamp) {
		this.selectCamp = selectCamp;
	}

	public UserBean getUserBeanHome() {
		return userBeanHome;
	}

	public void setUserBeanHome(UserBean userBeanHome) {
		this.userBeanHome = userBeanHome;
	}

	public String getBuscador() {
		return buscador;
	}

	public HomeBean() {

	}

	public void setBuscador(String buscado) {
		this.buscador = buscado;
	}
	
	public ArrayList<UserBean> getListaUsuariosBean() {
		return listaUsuariosBean;
	}
	
	public void setListaUsuariosBean(ArrayList<UserBean> listaUsuariosBean) {
		this.listaUsuariosBean = listaUsuariosBean;
	}

	public ArrayList<ConfigOptionsTo> getListaConfigOptions() {
		return listaConfigOptions;
	}

	public void setListaConfigOptions(ArrayList<ConfigOptionsTo> listaConfigOptions) {
		this.listaConfigOptions = listaConfigOptions;
	}

	

}
