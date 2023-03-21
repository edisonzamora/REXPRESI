package com.rexssecurity.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rexpress.beans.UserBean;
import com.rexssecurity.entitys.Usuario;

//public interface UsuarioDao extends CrudDao{
public interface UsuarioDao{
	
public void	altaUsuario(Usuario usuario) throws Exception;


public List<Usuario> userQueryCorreo(UserBean usuario);


public Usuario userQueryNombre(String nombre);


public List<Usuario> userQueryNombreList(String nombre);


public List<Usuario> usersQueryRole(String value);

public List<Usuario> usersQueryFilter(String tipo , String campo , String valor);


public List<Usuario> listaUsuarios();

public void listPrubea();

   

}
