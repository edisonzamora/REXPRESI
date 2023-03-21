package com.rexssecurity.services;


import java.util.ArrayList;

import com.rexpress.beans.UserBean;
import com.rexpress.common.service.CrudService;
import com.rexssecurity.entitys.Usuario;

public interface UsuaioService extends CrudService<UserBean, Usuario> {
	public UserBean crearUsuario (Usuario entity );
	public UserBean usuarioToUserbean ( UserBean user , Usuario entity );
	public Usuario userBeanToUsuario ( Usuario entity , UserBean user );
	public UserBean UsuarioByCorreo ( UserBean userBean );
	public ArrayList<UserBean> usuariosByTipo (String role);
	public ArrayList<UserBean> listaUsuarios();
	public UserBean UsuarioByNombre ( String nombre );
	public ArrayList<UserBean> UsuarioByNombreList ( String nombre );
	public ArrayList<UserBean> UsuarioByfilter ( String tipo , String campo , String valor );
	public ArrayList<UserBean> UsuarioByfilter ( String campo , String valor );
	
	
}
