package com.goMovie.Servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.goMovie.Modelo.DetalleOrden;
import com.goMovie.Modelo.Genero;

@Service
public interface GeneroServicio {

	List<Genero> findAll();
	
}
