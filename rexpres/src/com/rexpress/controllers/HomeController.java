package com.rexpress.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import com.rexpress.beans.HomeBean;
import com.rexpress.beans.UserBean;
import com.rexpress.constant.BeansName;
import com.rexpress.services.configoptions.ConfigOptionsService;
import com.rexpress.to.ConfigOptionsTo;
import com.rexssecurity.services.UsuaioService;

@Controller
@Component(BeansName.BEAN_HOMECONTROLLERBEAN)
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class HomeController extends CommonController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier("UsuarioService")
	private UsuaioService usuService;
	
	@Autowired
	private ConfigOptionsService configOptions;

	@Autowired
	private HomeBean homeBean;
	
	public HomeBean getHomeBean() {
		return homeBean;
	}

	public void setHomeBean(HomeBean homeBean) {
		this.homeBean = homeBean;
	}
	private String tipe = "";

	private ArrayList<UserBean> listaUsuariosBean;
	
	public HomeController() {

	}
	
	public String getTipe() {
		return tipe;
	}
	public void setTipe(String tipe) {
		this.tipe = tipe;
	}
	
	public void setListaUsuariosBean(ArrayList<UserBean> listaUsuariosBean) {
		this.listaUsuariosBean = listaUsuariosBean;
	}
	public ArrayList<UserBean> getListaUsuariosBean() {
		return listaUsuariosBean;
	}

	@PostConstruct
	private void  cargaLista() {
//		<ui:repeat var="item" value="#{mapBean.myMap[key]}">
//		Collections.unmodifiableList(new ArrayList<Country>(countryMap.values()))
		UsuaioService usuService = getBean(UsuaioService.class);
		listaUsuariosBean = usuService.listaUsuarios();
		homeBean.setListaUsuariosBean(listaUsuariosBean);
		//ArrayList<ConfigOptionsTo> list=(ArrayList<ConfigOptionsTo>) configOptions.allConfigOrtions();
		ArrayList<ConfigOptionsTo> list=new ArrayList<ConfigOptionsTo>();
		for (int i = 0; i < 3; i++) {
			ConfigOptionsTo	linnk=new ConfigOptionsTo();
			linnk.setNombre("link"+(i+1));
			linnk.setValor("value"+(i+1));
			linnk.setActivo("1");
			list.add(linnk);
		}
		homeBean.setListaConfigOptions(list);
	
	}
	private void cleanFilter() {
		homeBean.setBuscador("");
		homeBean.setSelectCamp("");
		
	}
	public void buscar() {
		if (!tipe.equalsIgnoreCase("") && !homeBean.getBuscador().equalsIgnoreCase("") && !homeBean.getSelectCamp().equalsIgnoreCase(""))
			homeBean.setListaUsuariosBean(usuService.UsuarioByfilter(tipe, homeBean.getSelectCamp(), homeBean.getBuscador()));
		if (tipe.equalsIgnoreCase("") && !homeBean.getSelectCamp().equalsIgnoreCase("") && !homeBean.getBuscador().equalsIgnoreCase(""))
			homeBean.setListaUsuariosBean(usuService.UsuarioByfilter(homeBean.getSelectCamp(), homeBean.getBuscador()));
		if (homeBean.getBuscador().equalsIgnoreCase("") && !tipe.equalsIgnoreCase(""))
			homeBean.setListaUsuariosBean(usuService.usuariosByTipo(tipe));
		if (homeBean.getBuscador().equalsIgnoreCase("") && tipe.equalsIgnoreCase(""))
			homeBean.setListaUsuariosBean(usuService.listaUsuarios());
	}
	
	public void tipoUsuario() {
		tipe = getParameter("tipo");
		if (tipe.equalsIgnoreCase("all"))
			homeBean.setListaUsuariosBean(usuService.listaUsuarios());
		else
			homeBean.setListaUsuariosBean(usuService.usuariosByTipo(tipe));
		cleanFilter();
	}
	
	
	
	public void editarUsuario(){
		
	UserBean ususelect=	homeBean.getUserBeanHome();
	ususelect.getActivo();
	 Map<String,Object> options = new HashMap<String, Object>();
     options.put("modal", true);
     options.put("width", 640);
     options.put("height", 340);
     options.put("contentWidth", "100%");
     options.put("contentHeight", "100%");
     options.put("headerElement", "customheader");
	PrimeFaces.current().dialog().openDynamic("librosView", options, null);
	}
	public void getlibros(){
		System.out.println("si");
//		configOptions.allConfigOrtions();
//		Map<String,Object> options = new HashMap<String, Object>();
//		options.put("modal", true);
//		options.put("contentHeight", 340);
//		options.put("height", 400);
//		options.put("width",700);
//		PrimeFaces.current().dialog().openDynamic("librosView",options,null);
	}
	
	
	public void geteditarEstadoAod(){
		 String summary = "edits";
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}
	
}
