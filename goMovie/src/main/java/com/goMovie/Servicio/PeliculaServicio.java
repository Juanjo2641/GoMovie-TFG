package com.goMovie.Servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.goMovie.Modelo.Pelicula;

@Service
public interface PeliculaServicio {
	List<Pelicula> findAll();
	List<Pelicula> generos(int genero);
	List<Pelicula> ofertas();
}
