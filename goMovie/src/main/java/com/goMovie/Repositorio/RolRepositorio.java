package com.goMovie.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goMovie.Modelo.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Integer> {

	public Rol findRolByNombre(String nombre);

}
