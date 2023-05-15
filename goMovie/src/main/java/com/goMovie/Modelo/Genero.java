package com.goMovie.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "generos")
public class Genero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_genero;
	private String nombre;
	
	
	public Genero() {
		super();
	}
	
	public Genero(int id_genero, String nombre) {
		super();
		this.id_genero = id_genero;
		this.nombre = nombre;
	}

	public int getId_genero() {
		return id_genero;
	}
	
	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	
}
