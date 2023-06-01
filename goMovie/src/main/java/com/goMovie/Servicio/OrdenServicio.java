package com.goMovie.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.goMovie.Modelo.Orden;
import com.goMovie.Modelo.Usuario;

@Service
public interface OrdenServicio {
	List<Orden> findAll();
	Orden findById(int id_orden);
	Orden save (Orden orden);
	String generarNumeroOrden();
	List<Orden> findByUsuario (Usuario usuario);
	
	
	
}
