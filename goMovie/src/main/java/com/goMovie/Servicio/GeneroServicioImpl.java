package com.goMovie.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goMovie.Modelo.DetalleOrden;
import com.goMovie.Modelo.Genero;
import com.goMovie.Repositorio.DetalleOrdenRepositorio;
import com.goMovie.Repositorio.GeneroRepositorio;
import com.goMovie.Repositorio.OrdenRepositorio;

@Service
public class GeneroServicioImpl implements GeneroServicio {
	
	@Autowired(required = false)
	private GeneroRepositorio generoRepositorio;

	@Override
	public List<Genero> findAll() {
		return generoRepositorio.findAll();
	}


}
