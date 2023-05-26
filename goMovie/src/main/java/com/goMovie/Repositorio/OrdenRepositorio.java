package com.goMovie.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goMovie.Modelo.Orden;
import com.goMovie.Modelo.Usuario;

public interface OrdenRepositorio extends JpaRepository<Orden, Integer> {

	List<Orden> findByUsuario (Usuario usuario);
}
