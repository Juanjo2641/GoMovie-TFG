package com.goMovie.Servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goMovie.Modelo.Orden;
import com.goMovie.Modelo.Tag;
import com.goMovie.Modelo.Usuario;
import com.goMovie.Repositorio.OrdenRepositorio;
import com.goMovie.Repositorio.PeliculaRepositorio;

@Service
public class OrdenServicioImpl implements OrdenServicio {

	@Autowired(required = false)
	private OrdenRepositorio ordenRepositorio;
	
	@Override
	public List<Orden> findAll() {
		return ordenRepositorio.findAll();
	}
	
	@Override
	public Orden findById(int id_orden) {
		Optional<Orden> ordenOptional = ordenRepositorio.findById(id_orden);
	    return ordenOptional.orElse(null); 
	}

	
	public List<Orden> findByUsuario(Usuario usuario) {
		return ordenRepositorio.findByUsuario(usuario);
	}


	@Override
	public String generarNumeroOrden() {
		int numero = 0;
		String numeroConcatenado = "";

		List<Orden> ordenes = findAll();

		List<Integer> numeros = new ArrayList<Integer>();

		ordenes.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumero())));

		if (ordenes.isEmpty()) {
			numero = 1;
		} else {
			numero = numeros.stream().max(Integer::compare).get();
			numero++;
		}

		if (numero < 10) { // 0000001000
			numeroConcatenado = "000000000" + String.valueOf(numero);
		} else if (numero < 100) {
			numeroConcatenado = "00000000" + String.valueOf(numero);
		} else if (numero < 1000) {
			numeroConcatenado = "0000000" + String.valueOf(numero);
		} else if (numero < 10000) {
			numeroConcatenado = "0000000" + String.valueOf(numero);
		}

		return numeroConcatenado;
		
	}


	@Override
	public Orden save(Orden orden) {
		return ordenRepositorio.save(orden);		

	}



}

