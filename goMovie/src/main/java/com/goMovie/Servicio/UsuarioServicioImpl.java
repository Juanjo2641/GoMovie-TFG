package com.goMovie.Servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.usuarios.exception.UserNotEnabledException;
import org.springframework.stereotype.Service;

import com.goMovie.UsuariosDTO.UsuarioRegistroDTO;
import com.goMovie.Modelo.Rol;
import com.goMovie.Modelo.Usuario;
import com.goMovie.Repositorio.RolRepositorio;
import com.goMovie.Repositorio.UsuarioRepositorio;



@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private RolRepositorio rolRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.setUsuarioRepositorio(usuarioRepositorio);
	}

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) throws ConstraintViolationException {
		
		Rol userRole = rolRepository.findRolByNombre("USER");
		if (userRole == null) {
			userRole = new Rol("USER");
		}
		
		Usuario usuario = new Usuario(			
							registroDTO.getNombre(),
							registroDTO.getApellido(),
							registroDTO.getEmail(),
							passwordEncoder.encode(registroDTO.getPassword()),
							Arrays.asList(userRole));
		
		return usuarioRepositorio.save(usuario);
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		/*if(usuario == null) {
			throw new UsernameNotFoundException("Email o contraseña erroneos");		
		}*/
		return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}

	public UsuarioRepositorio getUsuarioRepositorio() {
		return usuarioRepositorio;
	}

	public void setUsuarioRepositorio(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}


	@Override
	public Usuario findById(int id_usuario) {
		return usuarioRepositorio.findById(id_usuario);
	}

	@Override
	public List<Usuario> mostrarPerfiles(String emaillogueado) {
		return usuarioRepositorio.mostrarPerfiles(emaillogueado);
	}

	@Override
	public Usuario findByEmail(String email) {
		return usuarioRepositorio.findByEmail(email);
	}

	@Override
	public void actualizarDir(int idUsuario, String direccion) {
		usuarioRepositorio.actualizarDir(idUsuario, direccion);
		
	}

	@Override
	public void actualizarDni(int idUsuario, String dni) {
		usuarioRepositorio.actualizarDni(idUsuario, dni);
	}

	@Override
	public int cogerPerfilId(String emailLogueado) {
		return usuarioRepositorio.cogerPerfilId(emailLogueado);
	}
	
	
	
}
