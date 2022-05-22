package com.persistence.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="estado")
@NamedQueries({
	
	@NamedQuery(name="Estado.list" , query="select e from Estado e"),
	@NamedQuery(name="Estado.id" , query="select e from Estado e where e.id = :id"),
	@NamedQuery(name="Estado.nombre" , query="select e from Estado e where e.nombre = :nombre")
})
public class Estado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	public int getId() {
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

	public Estado() {
		// TODO Auto-generated constructor stub
	}

}
