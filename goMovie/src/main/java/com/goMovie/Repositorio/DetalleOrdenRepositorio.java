package com.goMovie.Repositorio;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goMovie.Modelo.DetalleOrden;

@Repository
public interface DetalleOrdenRepositorio extends JpaRepository<DetalleOrden, Integer>{
	
	@Query(value="SELECT * FROM Detalles WHERE id = :id_orden", nativeQuery = true)
	List<DetalleOrden> findByIdOrden(@Param("id_orden") int id_orden);
    
}
