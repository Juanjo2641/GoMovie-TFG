package com.goMovie.Servicio;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.goMovie.Modelo.Usuario;
import com.goMovie.UsuariosDTO.UsuarioRegistroDTO;

public interface UsuarioServicio extends UserDetailsService{
	
	
	
	public Usuario guardar(UsuarioRegistroDTO registroDTO) throws ConstraintViolationException;
	
	Usuario findById(int id_usuario);
	List<Usuario> mostrarPerfiles(String emaillogueado);
	Usuario findByEmail(String email);
	public void actualizarDir(int idUsuario, String direccion);
	public void actualizarDni(int idUsuario, String dni);
	public int cogerPerfilId(String emailLogueado);
	
}
