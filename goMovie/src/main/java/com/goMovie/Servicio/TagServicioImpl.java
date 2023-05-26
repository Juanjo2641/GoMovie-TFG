package com.goMovie.Servicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goMovie.Modelo.Pelicula;
import com.goMovie.Modelo.Tag;
import com.goMovie.Repositorio.PeliculaRepositorio;
import com.goMovie.Repositorio.TagRepositorio;

@Service
public class TagServicioImpl implements TagServicio {
	
	@Autowired(required = false)
	private TagRepositorio tagRepositorio;
	
	public Tag findByNombre(String nombre) {
	    return tagRepositorio.findByNombre(nombre);
	}

	@Override
	public List<Tag> findAll() {
		return tagRepositorio.findAll();
	}

	@Override
	public Tag findByID(int id) {
		Optional<Tag> tagOptional = tagRepositorio.findById(id);
	    return tagOptional.orElse(null); 
	}
}
