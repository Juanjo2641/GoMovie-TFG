package com.goMovie.Repositorio;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.goMovie.Modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	

	public Usuario findByEmail(String email);
	
    @Query(value="SELECT id_usuario FROM Usuarios WHERE email = :emailLogueado", nativeQuery=true)
    int cogerPerfilId(@Param("emailLogueado") String emailLogueado);
	
    @Query(value="SELECT * FROM Usuarios WHERE email = :emailLogueado", nativeQuery=true)
    List<Usuario> mostrarPerfiles(@Param("emailLogueado") String emailLogueado);
	
    @Modifying
    @Transactional    
    @Query(value="UPDATE `usuarios` SET `direccion` = :direccion  WHERE `id_usuario` = :id", nativeQuery=true)
    int actualizarDir(@Param("id") int id, @Param("direccion") String direccion);
    
    @Modifying
    @Transactional    
    @Query(value="UPDATE `Usuarios` SET `dni` = :dni  WHERE `Usuarios`.`id_Usuario` = :id", nativeQuery=true)
    int actualizarDni(@Param("id") long id, @Param("dni") String dni);
    
    
    @Query(value="SELECT * FROM Usuarios WHERE id_usuario = :id_usuario", nativeQuery=true)
    Usuario findById(@Param("id_usuario") int id_usuario);
    
    
    
}
