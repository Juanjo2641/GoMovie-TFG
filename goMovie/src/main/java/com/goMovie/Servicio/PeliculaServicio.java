package com.goMovie.Servicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.goMovie.Modelo.Pelicula;
import com.goMovie.Modelo.Tag;

@Service
public interface PeliculaServicio {
	List<Pelicula> findAll();
	Pelicula findByID(int id_pelicula);
	List<Pelicula> generos(int genero);
	List<Pelicula> ofertas();
	List<Pelicula> buscador(String busqueda);
	List<Pelicula> findByTagId(int tagId);
	
	List<Pelicula> administracion(int descatalogado);

    Pelicula get(int id);

	Pelicula save(Pelicula pelicula);
	List<Pelicula> findByIDs(List<Integer> ids);
}
