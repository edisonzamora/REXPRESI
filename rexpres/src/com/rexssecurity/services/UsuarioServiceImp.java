package com.rexssecurity.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rexpress.beans.UserBean;
import com.rexpress.common.dao.CrudDao;
import com.rexpress.common.service.CommonServices;
import com.rexpress.common.service.CrudServiceImp;
import com.rexssecurity.dao.UsuarioDao;
import com.rexssecurity.entitys.Usuario;

@Service("UsuarioService")
public class UsuarioServiceImp extends CommonServices<UserBean, Usuario> implements UsuaioService {

	@Autowired
	private UsuarioDao usuariodao;


	@Override
	public UserBean usuarioToUserbean(UserBean user, Usuario entity) {
		/*
		 * cambia la entidad a usuarioBean
		 */
		user.setIdusuario(entity.getIdusuario());
		user.setNombre(entity.getNombre());
		user.setApellido(entity.getApellido());
		user.setCorreo(entity.getCorreo());
		user.setPassword(entity.getPassword());
		user.setActivo(entity.getActivo());
		user.setRole(entity.getRole());
		return user;
	}

	@Override
	public Usuario userBeanToUsuario(Usuario entity, UserBean user) {
		/*
		 * cambia de userBean a Entity
		 */
		entity.setIdusuario(user.getIdusuario());
		entity.setNombre(user.getNombre());
		entity.setApellido(user.getApellido());
		entity.setCorreo(user.getCorreo());
		entity.setPassword(user.getPassword());
		entity.setActivo(user.getActivo());
		entity.setRole(user.getRole());
		return entity;
	}

	@Override
	public UserBean UsuarioByCorreo(UserBean userBean) {
		List<Usuario> usuriosList = usuariodao.userQueryCorreo(userBean);
		if (!usuriosList.isEmpty()) {
			if (usuriosList.size() == 1) {
				usuarioToUserbean(userBean, usuriosList.get(0));
				return userBean;

			} else {
				userBean = null;
				return userBean;
			}
		}
		userBean = null;
		return userBean;

	}

	@Override
	public ArrayList<UserBean> usuariosByTipo(String role) {
		// TODO Auto-generated method stub
		ArrayList<Usuario> usuarios = null;
		if (role.equalsIgnoreCase("ADM")) {
			usuarios = (ArrayList<Usuario>) usuariodao.usersQueryRole(role);
		}
		if (role.equalsIgnoreCase("USU")) {
			usuarios = (ArrayList<Usuario>) usuariodao.usersQueryRole(role);
		}

		return (ArrayList<UserBean>) usuarioToUserBeanList(usuarios);
	}

	@Override
	public UserBean crearUsuario(Usuario entity) {
		// TODO Auto-generated method stub
		try {
			usuariodao.altaUsuario(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<UserBean> listaUsuarios() {
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuariodao.listaUsuarios();
		return (ArrayList<UserBean>) usuarioToUserBeanList(usuarios);
	}

	@Override
	public UserBean UsuarioByNombre(String nombre) {
		Usuario user = usuariodao.userQueryNombre(nombre);
		UserBean userBean = new UserBean();
		usuarioToUserbean(userBean, user);
		return userBean;
	}

	@Override
	public ArrayList<UserBean> UsuarioByNombreList(String nombre) {
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuariodao.userQueryNombreList(nombre);
		return (ArrayList<UserBean>) usuarioToUserBeanList(usuarios);
	}

	@Override
	public ArrayList<UserBean> UsuarioByfilter(String role, String campo, String valor) {
				List<Usuario> listUsuarios = usuariodao.usersQueryFilter(role, campo, valor);
				return (ArrayList<UserBean>) usuarioToUserBeanList(listUsuarios);
	}

	@Override
	public ArrayList<UserBean> UsuarioByfilter(String campo, String valor) {
		return UsuarioByfilter(null, campo, valor);
	}
	
	private List<UserBean> usuarioToUserBeanList(List<Usuario> usuario) {

		ArrayList<UserBean> usuariosbean = new ArrayList<>();
		for (Usuario varia : usuario) {
			UserBean user = new UserBean();
			usuariosbean.add(usuarioToUserbean(user, varia));
		}

		return usuariosbean;
	}


}
