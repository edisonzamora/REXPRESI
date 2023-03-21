package com.rexssecurity.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rexpress.beans.UserBean;


public class UsuarioDetailsService implements UserDetailsService {

	@Autowired
	private UsuaioService usuaioService;
	
	public UsuarioDetailsService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stubç
		UserBean userBeanTmp=null;
		try{
		 userBeanTmp= usuaioService.UsuarioByNombre(username);
		}catch (NoResultException e) {
			// TODO: handle exception
		}finally {
			if(userBeanTmp==null){
				throw new UsernameNotFoundException("No se ha encontrado el usuario");
			}
			
		}
		List<GrantedAuthority> roles=new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		User usuario=new User(userBeanTmp.getNombre(), userBeanTmp.getPassword(),roles );
		return usuario;
	}

	
	
}
