package com.goMovie.Controlador;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import com.goMovie.Modelo.Pelicula;
import com.goMovie.Servicio.PeliculaServicio;

@Controller
@RequestMapping("/")
public class goMovieControlador {
	

	@Autowired
	private PeliculaServicio peliculaServicio;

	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}

	@GetMapping("/inicio")
	public String listar(Model model) {
		List<Pelicula> peliculas = peliculaServicio.findAll();
		model.addAttribute("peliculas", peliculas);
 
		return "inicio";
	}
	
	
			/* CATEGORIAS */
	@GetMapping("/fantasia")
	public String fantasia(Model model) {
		List<Pelicula> peliculas = peliculaServicio.generos(1);
		model.addAttribute("peliculas", peliculas);
		
		return "inicio";
	}
	
	@GetMapping("/drama")
	public String drama(Model model) {
		List<Pelicula> peliculas = peliculaServicio.generos(2);
		model.addAttribute("peliculas", peliculas);

		
		return "inicio";
	}
	
	@GetMapping("/romantico")
	public String romantico(Model model) {
		List<Pelicula> peliculas = peliculaServicio.generos(3);
		model.addAttribute("peliculas", peliculas);
		
		return "inicio";
	}
	
	@GetMapping("/comedia")
	public String comedia(Model model) {
		List<Pelicula> peliculas = peliculaServicio.generos(4);
		model.addAttribute("peliculas", peliculas);
		
		return "inicio";
	}
	
	@GetMapping("/infantil")
	public String infantil(Model model) {
		List<Pelicula> peliculas = peliculaServicio.generos(5);
		model.addAttribute("peliculas", peliculas);
		
		return "inicio";
	}
	
	@GetMapping("/accion")
	public String accion(Model model) {
		List<Pelicula> peliculas = peliculaServicio.generos(6);
		model.addAttribute("peliculas", peliculas);
		
		return "inicio";
	}
			/* CATEGORIAS */
	
	
	
			/* OFERTAS */
	@GetMapping("/ofertas")
	public String ofertas(Model model) {
	    List<Pelicula> peliculas = peliculaServicio.ofertas();
	    Map<Pelicula, String> preciosFinales = new HashMap<>();
	    
	    for (Pelicula pelicula : peliculas) {
	        int rebajaPelicula = pelicula.getRebaja();
	        float precioPelicula = pelicula.getPrecio();
	        float descuento = (precioPelicula * rebajaPelicula) / 100;
	        float precioFinal = precioPelicula - descuento;
	        
	        String precioFormateado = String.format("%.2f", precioFinal);
	        preciosFinales.put(pelicula, precioFormateado);
	    }
	    
	    peliculas.sort(Comparator.comparingInt(Pelicula::getRebaja).reversed());
	    List<Pelicula> peliculasDestacadas = peliculas.stream().limit(3).collect(Collectors.toList());
	    model.addAttribute("peliculasDestacadas", peliculasDestacadas);
	    
	    List<Pelicula> peliculasRestantes = peliculas.stream().skip(3).collect(Collectors.toList());

	    model.addAttribute("peliculasDestacadas", peliculasDestacadas);
	    model.addAttribute("peliculasRestantes", peliculasRestantes);
	    
	    model.addAttribute("preciosFinales", preciosFinales);
	    
	    return "ofertas";
	}
			/* OFERTAS */

	
	
	@GetMapping("/lista")
	public String tulista() {
		return "lista";
	}

	@GetMapping("/proximamente")
	public String proximamente() {
		return "proximamente";
	}
	
	@GetMapping("/login")
	public String iniciarSesion(Model model, String error) {

		return "login";
	}

	@GetMapping("/signup")
	public String registrarse() {
		return "signup";
	}

	@GetMapping("/carrusel")
	public String carrusel() {
		return "carrusel";
	}
	
	@GetMapping("/detalles")
	public String detalles() {
		return "detalles";
	}


	@GetMapping("/perfil")
	public String entrarPerfil(Model model, String perfiles) {
		return "perfil";

	}



}
