package com.goMovie.Repositorio;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.goMovie.Modelo.Genero;
import com.goMovie.Modelo.Pelicula;
import com.goMovie.Modelo.Tag;



@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, Integer> {



}
