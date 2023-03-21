package com.rexpress.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class ConfigOptions  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Integer id;
	

	public String nombre;
	

	public String valor;
	

	public Integer activo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public ConfigOptions(Integer id, String nombre, String valor, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.activo = activo;
	}

	public ConfigOptions() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
