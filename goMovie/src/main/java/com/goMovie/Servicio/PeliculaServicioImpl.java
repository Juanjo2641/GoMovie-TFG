package com.goMovie.Servicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goMovie.Modelo.Pelicula;
import com.goMovie.Modelo.Tag;
import com.goMovie.Repositorio.PeliculaRepositorio;

@Service
public class PeliculaServicioImpl implements PeliculaServicio {

	@Autowired(required = false)
	private PeliculaRepositorio peliculaRepositorio;
	

	
	@Override
	public List<Pelicula> findAll() {
		return peliculaRepositorio.findAll();
	}
	
	@Override
	public Pelicula findByID(int id_pelicula) {
		Optional<Pelicula> peliculaOptional = peliculaRepositorio.findById(id_pelicula);
	    return peliculaOptional.orElse(null); 
	}

	@Override
	public List<Pelicula> generos(int genero) {
		return peliculaRepositorio.generos(genero);
	}

	@Override
	public List<Pelicula> ofertas() {
		return peliculaRepositorio.ofertas();
	}

	@Override
	public List<Pelicula> buscador(String busqueda) {
		return peliculaRepositorio.buscador(busqueda);
	}

	@Override
	public List<Pelicula> findByTagId(int tagId) {
		return peliculaRepositorio.findByTagId(tagId);
	}

	@Override
	public Pelicula get(int id) {
		return peliculaRepositorio.get(id);
	}

	@Override
	public Pelicula save(Pelicula pelicula) {
		return peliculaRepositorio.save(pelicula);
	}

	@Override
	public List<Pelicula> administracion(int descatalogado) {
		return peliculaRepositorio.administracion(descatalogado);
	}

	@Override
	public List<Pelicula> findByIDs(List<Integer> ids) {
	    return peliculaRepositorio.findByIDs(ids);
	}

}

