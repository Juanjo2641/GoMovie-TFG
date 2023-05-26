package com.goMovie.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tags")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tag;
	private String nombre;
	
    @ManyToMany(mappedBy = "tags")
    private Set<Pelicula> peliculas = new HashSet<>();

	
	
	public Tag() {
		super();
	}
	
	public Tag(int id_tag, String nombre) {
		super();
		this.id_tag = id_tag;
		this.nombre = nombre;
	}

	
	public int getId_tag() {
		return id_tag;
	}

	public void setId_tag(int id_tag) {
		this.id_tag = id_tag;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	@Override
	public String toString() {
		return "Tags [id_tag=" + id_tag + ", nombre=" + nombre + "]";
	}

}
