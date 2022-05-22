package com.persistence.rexpres.jpa.dao;

import java.util.List;

import com.persistence.entities.Estado;

public interface EstadoDao{

public Estado buscarPorIdNamedQuery(String namedQuery ,String K ,Integer Value);

 public List<Estado> buscarPorNombreNamedQuery(String namedQuery ,String K , String Value);
	
}
