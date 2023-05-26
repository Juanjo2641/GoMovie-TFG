package com.goMovie.Servicio;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goMovie.Modelo.Pelicula;
import com.goMovie.Modelo.Tag;
import com.goMovie.Repositorio.TagRepositorio;

@Service
public interface TagServicio {

	Tag findByNombre(String nombre);
	List<Tag> findAll();
	Tag findByID(int id);
}
