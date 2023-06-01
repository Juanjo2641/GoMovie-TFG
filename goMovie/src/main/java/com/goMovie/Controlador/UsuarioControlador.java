package com.goMovie.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goMovie.Servicio.UsuarioServicio;
import com.goMovie.UsuariosDTO.UsuarioRegistroDTO;


@Controller
@RequestMapping("/signup")
public class UsuarioControlador {

	
	private UsuarioServicio usuarioServicio;

	public UsuarioControlador(UsuarioServicio usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}
	
	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "signup";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
		try{
			usuarioServicio.guardar(registroDTO);
			
		}catch(Exception e) {
			return "redirect:/signup?fallo";		
		}
		return "redirect:/signup?exito";  
	}
	
	
}
