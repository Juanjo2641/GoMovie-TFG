package com.goMovie.Servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.goMovie.Modelo.DetalleOrden;

@Service
public interface DetalleOrdenServicio {
	DetalleOrden save (DetalleOrden detalleOrden);
	
	List<DetalleOrden> findByIdOrden(int id_orden);
		
}
