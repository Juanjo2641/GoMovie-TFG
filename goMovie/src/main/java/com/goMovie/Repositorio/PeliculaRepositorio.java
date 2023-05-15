package com.goMovie.Repositorio;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.goMovie.Modelo.Pelicula;



@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Integer> {
	
	@Query(value="SELECT * FROM Peliculas WHERE id_genero = :genero", nativeQuery=true)
	List<Pelicula> generos(@Param("genero") int genero);
	
	@Query(value="SELECT * FROM Peliculas WHERE rebaja > 0", nativeQuery=true)
	List<Pelicula> ofertas();
}
