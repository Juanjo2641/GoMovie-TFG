package com.goMovie.Repositorio;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.goMovie.Modelo.Pelicula;
import com.goMovie.Modelo.Tag;



@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Integer> {
	
	@Query(value = "SELECT * FROM Peliculas WHERE id_genero = :genero", nativeQuery = true)
	List<Pelicula> generos(@Param("genero") int genero);
	
	@Query(value = "SELECT * FROM Peliculas WHERE rebaja > 0", nativeQuery=true)
	List<Pelicula> ofertas();
	
	@Query(value = "SELECT * FROM Peliculas WHERE nombre LIKE %:busqueda%", nativeQuery = true)
	List<Pelicula> buscador(@Param("busqueda") String busqueda);
	
	@Query(value = "SELECT p.* FROM Peliculas p JOIN peliculas_tags pt ON p.id_pelicula = pt.id_pelicula JOIN tags t ON t.id_tag = pt.id_tag WHERE t.id_tag = :tagId", nativeQuery = true)
	List<Pelicula> findByTagId(@Param("tagId") int tagId);

	@Query(value = "SELECT * FROM Peliculas WHERE descatalogado = :descatalogado", nativeQuery = true)
	List<Pelicula> administracion(@Param("descatalogado") int descatalogado);
	
	@Query(value = "SELECT * FROM Peliculas WHERE id_pelicula = :id", nativeQuery = true)
	Pelicula get(@Param("id") int id);

	@Query("SELECT p FROM Pelicula p WHERE p.id IN :ids")
	List<Pelicula> findByIDs(@Param("ids") List<Integer> ids);


}
