package com.goMovie.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goMovie.Modelo.DetalleOrden;
import com.goMovie.Repositorio.DetalleOrdenRepositorio;
import com.goMovie.Repositorio.OrdenRepositorio;

@Service
public class DetalleOrdenServicioImpl implements DetalleOrdenServicio {
	
	@Autowired(required = false)
	private DetalleOrdenRepositorio detalleOrdenRepositorio;

	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {
		return detalleOrdenRepositorio.save(detalleOrden);
	}

	@Override
	public List<DetalleOrden> findByIdOrden(int id_orden) {
		return detalleOrdenRepositorio.findByIdOrden(id_orden);
	}


}
