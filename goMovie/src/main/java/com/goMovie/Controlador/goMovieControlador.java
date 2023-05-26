package com.goMovie.Controlador;


import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goMovie.Modelo.DetalleOrden;
import com.goMovie.Modelo.Orden;
import com.goMovie.Modelo.Pelicula;
import com.goMovie.Modelo.Tag;
import com.goMovie.Modelo.Usuario;
import com.goMovie.Servicio.DetalleOrdenServicio;
import com.goMovie.Servicio.OrdenServicio;
import com.goMovie.Servicio.PeliculaServicio;
import com.goMovie.Servicio.TagServicio;
import com.goMovie.Servicio.UsuarioServicio;


@Controller
@RequestMapping("/")
public class goMovieControlador {
	
	private static final Logger log = Logger.getLogger(goMovieControlador.class);
	

	@Autowired
	private PeliculaServicio peliculaServicio;
	
	@Autowired
	private TagServicio tagServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private OrdenServicio ordenServicio;
	
	@Autowired
	private DetalleOrdenServicio detalleOrdenServicio;
	
	List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();
	Orden orden = new Orden();

	
			/* PAGINAS PRINCIPALES */
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/inicio")
	public String listar(String busqueda, Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "6") int pageSize) {

		List<Pelicula> peliculas;
		
		if (busqueda != null && !busqueda.isEmpty()) {
			peliculas = peliculaServicio.buscador(busqueda);
		} else {
			peliculas = peliculaServicio.findAll();
		}

		int start = page * pageSize;
		int end = Math.min((start + pageSize), peliculas.size());
		int totalPeliculas = peliculas.size();
		List<Pelicula> peliculasPaginadas = peliculas.subList(start, end);

		model.addAttribute("peliculas", peliculasPaginadas);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", (int) Math.ceil((double) peliculas.size() / pageSize));
		model.addAttribute("pageSize", pageSize);

		model.addAttribute("totalProductos", totalPeliculas);

		if (busqueda != null && !busqueda.isEmpty()) {
			model.addAttribute("busqueda", busqueda);
			return "busqueda";

		}else {
			return "inicio";
		}


	}
			/* PAGINAS PRINCIPALES */
	

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
	
	@GetMapping("/todas")
	public String todas(Model model) {
		List<Pelicula> peliculas = peliculaServicio.findAll();
		model.addAttribute("peliculas", peliculas);
		
		return "inicio";
	}
			/* CATEGORIAS */
	
	
	
			/* TAGS */
	@GetMapping("/{tagName}")
	public String categoriaTags(@PathVariable String tagName, Model model) {
	    Tag tag = tagServicio.findByNombre(tagName);
	    if (tag != null) {
	        List<Pelicula> peliculas = peliculaServicio.findByTagId(tag.getId_tag());
	        model.addAttribute("peliculas", peliculas);
	        return "categoria";
	    } else {
	        return "inicio";
	    }
	}
			/* TAGS */
	
	
	
			/* OFERTAS */
	@GetMapping("/ofertas")
	public String ofertas(Model model) {
	    List<Pelicula> peliculas = peliculaServicio.ofertas();
	    Map<Pelicula, String> preciosFinales = new HashMap<>();
	    
	    for (Pelicula pelicula : peliculas) {
	        int rebajaPelicula = pelicula.getRebaja();
	        double precioPelicula = pelicula.getPrecio();
	        double descuento = (precioPelicula * rebajaPelicula) / 100;
	        double precioFinal = precioPelicula - descuento;
	        
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



			/* DETALLES */
	@GetMapping("/detalles/{id_pelicula}")
	public String detalles(@PathVariable("id_pelicula") int id_pelicula, Model model) {
		Pelicula pelicula = peliculaServicio.findByID(id_pelicula);
		model.addAttribute("pelicula", pelicula);
		
		return "detalles";

	}
			/* DETALLES */
	
	
	
			/* TU LISTA */
	@GetMapping("/lista")
	public String tulista() {
		return "lista";
	}
			/* TU LISTA */


	
			/* PROXIMAMENTE */
	@GetMapping("/proximamente")
	public String proximamente() {
		return "proximamente";
	}
			/* PROXIMAMENTE */
	
	
	
	
			/* LOGIN Y USUARIO */
	@GetMapping("/login")
	public String iniciarSesion(Model model, String error) {
		return "login";
	}


	@GetMapping("/perfil")
	public String entrarPerfil(Model model, String perfiles) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String emailLogueado = userDetail.getUsername();
		model.addAttribute("usuarios", usuarioServicio.mostrarPerfiles(emailLogueado));
		Usuario usuario = usuarioServicio.findByEmail(emailLogueado);
		List<Orden> ordenes = ordenServicio.findByUsuario(usuario);
		model.addAttribute("ordenes", ordenes);
		

		return "perfil";
	}

	@GetMapping("/modificarPerfil/{id}")
	public String modificarPerfil(@PathVariable int id, Model model) {
	    Usuario usuario = usuarioServicio.findById(id);
	    model.addAttribute("usuario", usuario);
	    return "modificarPerfil";
	}
			/* LOGIN Y USUARIO */
	
	
		
			/* ADMINISTRACION */
	@GetMapping("/administracion")
	public String administracion(Model model) {
		List<Pelicula> peliculas = peliculaServicio.administracion(0);
		
		model.addAttribute("peliculas", peliculas);
		return "administracion";
	}
	
	@GetMapping("/adminDescatalogado")
	public String adminDescatalogado(Model model) {
		List<Pelicula> peliculas = peliculaServicio.administracion(1);
		
		model.addAttribute("peliculas", peliculas);
		return "administracion";
	}
	
	@GetMapping("/modificarPelicula/{id_pelicula}")
	public String modificarPelicula(@PathVariable("id_pelicula") int id_pelicula, Model model) {
		Pelicula p = peliculaServicio.findByID(id_pelicula);
		List<Tag> allTags = tagServicio.findAll();
		
		model.addAttribute("pelicula", p);
		model.addAttribute("allTags", allTags);

		return "modificarPelicula";
	}
	
	@PostMapping("/actualizar")
	public String actualizarPelicula(Pelicula pelicula, String foto) {
		
		if(foto == "") {
			Pelicula p = new Pelicula();
			p = peliculaServicio.findByID((pelicula.getId_pelicula()));
			pelicula.setFoto(p.getFoto());
			peliculaServicio.save(pelicula);
		}else{
			String ruta = "../assets/img/peliculas/";
			pelicula.setFoto(ruta+foto);
			peliculaServicio.save(pelicula);
		}
		
		return "redirect:/administracion";
	}
	
	@GetMapping("/eliminarPelicula/{id_pelicula}")
	public String eliminarPelicula(@PathVariable("id_pelicula") int id_pelicula) {
		Pelicula p = peliculaServicio.findByID(id_pelicula);
		p.setDescatalogado(1);
		peliculaServicio.save(p);
		
		return "redirect:/administracion";
	}
			/* ADMINISTRACION */
	
			/* CARRITO */
	
	// AÑADIR
	@PostMapping("/añadirCarrito")
	public String añadirCarro(@RequestParam("id_pelicula") int id_pelicula, Model model) {
		DetalleOrden detalleOrden = new DetalleOrden();
		int cantidad = 1;
		double sumaTotal = 0;
		int sumaTotalProductos = 0;

		Pelicula pelicula = peliculaServicio.get(id_pelicula);
        detalleOrden.setNombre(pelicula.getNombre());
        detalleOrden.setCantidad(cantidad);
        detalleOrden.setTotal(pelicula.getPrecio() * cantidad);
        detalleOrden.setPrecio(pelicula.getPrecio());
        

        detalleOrden.setPelicula(pelicula);
        detalleOrden.setFoto(pelicula.getFoto());

        pelicula.setStock(pelicula.getStock() - cantidad);
        peliculaServicio.save(pelicula);


		// validar que le producto no se añada 2 veces

		Integer idPelicula = pelicula.getId_pelicula();
		boolean ingresado = detalles.stream().anyMatch(p -> p.getPelicula().getId_pelicula() == idPelicula);

		if (!ingresado) {
			detalles.add(detalleOrden);
		} else {
			detalles.stream().forEach(s -> {
				if (s.getPelicula().getId_pelicula() == idPelicula) {
					s.setCantidad(s.getCantidad() + 1);
					double preciosuma =s.getPrecio() * s.getCantidad();
					s.setTotal(Math.round(preciosuma * 100.0) / 100.0);
					s.getPelicula().setStock(s.getPelicula().getStock()-1);
				}
			});
		}

		sumaTotalProductos = detalles.stream().mapToInt(dt -> dt.getCantidad()).sum();
		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();
		orden.setCantidad(sumaTotalProductos);
		orden.setTotal(Math.round(sumaTotal * 100.0) / 100.0);
		model.addAttribute("carrito", detalles);
		model.addAttribute("orden", orden);
		System.out.println(detalles);
		System.out.println(orden);
		return "carrito";
	}

	
	// ELIMINAR
	@GetMapping("/delete/cart/{id_pelicula}")
	public String deleteProductoCart(@PathVariable int id_pelicula, Model model) {
		// lista nueva de productos
		List<DetalleOrden> ordenesNueva = new ArrayList<DetalleOrden>();

		for (DetalleOrden detalleOrden : detalles) {
			if (detalleOrden.getPelicula().getId_pelicula() != id_pelicula) {
				System.out.println(detalleOrden.getPelicula().getId_pelicula());
				ordenesNueva.add(detalleOrden);
			}else {
				Pelicula pelicula = peliculaServicio.get(id_pelicula);
				pelicula.setStock(pelicula.getStock() + detalleOrden.getCantidad());
				peliculaServicio.save(pelicula);
			}
		}
		
		// poner la nueva lista con los productos restantes
		detalles = ordenesNueva;
		double sumaTotal = 0;
		int sumaTotalPeliculas = 0;
		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();
		sumaTotalPeliculas = detalles.stream().mapToInt(dt -> dt.getCantidad()).sum();
		orden.setCantidad(sumaTotalPeliculas);
		orden.setTotal(Math.round(sumaTotal * 100.0) / 100.0);
		System.out.println(detalles);
		model.addAttribute("carrito", detalles);
		model.addAttribute("orden", orden);
		
		return "redirect:/carrito";
	}
	
	// SUMAR
	@GetMapping("/sumar/cart/{id_pelicula}")

	public String sumarProductoCart(@PathVariable int id_pelicula, Model model, RedirectAttributes redirectAttrs) {
		double sumaTotal = 0;
		int sumaTotalPeliculas = 0;
		Pelicula pelicula = peliculaServicio.get(id_pelicula);

		// validar que le producto no se añada 2 veces

		boolean existente = detalles.stream().anyMatch(p -> p.getPelicula().getId_pelicula() == id_pelicula);

		if(pelicula.getStock()!=0) {

			if (!existente) {
			} else {
				detalles.stream().forEach(s -> {

					if (s.getPelicula().getId_pelicula() == id_pelicula) {
						s.setCantidad(s.getCantidad() + 1);
						double preciosuma =s.getPrecio() * s.getCantidad();
						s.setTotal(Math.round(preciosuma * 100.0) / 100.0);
						s.getPelicula().setStock(s.getPelicula().getStock()-1);

					}
				});

			}

			pelicula.setStock(pelicula.getStock() - 1);
			peliculaServicio.save(pelicula);
			sumaTotalPeliculas = detalles.stream().mapToInt(dt -> dt.getCantidad()).sum();
			sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();
			orden.setCantidad(sumaTotalPeliculas);
			orden.setTotal(Math.round(sumaTotal * 100.0) / 100.0);
		}

		redirectAttrs
		.addFlashAttribute("mensaje", "No hay mas disponible")
		.addFlashAttribute("clase", "success");
		model.addAttribute("carrito", detalles);
		model.addAttribute("orden", orden);
		
		return "redirect:/carrito";
	}
	
	// RESTAR
	@GetMapping("/restar/cart/{id_pelicula}")

	public String restarProductoCart(@PathVariable int id_pelicula, Model model) {
		double sumaTotal = 0;
		int sumaTotalProductos = 0;

		// validar que la pelicula no se elimine 2 veces
		boolean existente = detalles.stream().anyMatch(p -> p.getPelicula().getId_pelicula() == id_pelicula);
		
		if (!existente) {
		} else {
			detalles.stream().forEach(s -> {
				
				if (s.getPelicula().getId_pelicula() == id_pelicula) {
					s.setCantidad(s.getCantidad() - 1);
					double precioxcantidad = s.getPrecio() * s.getCantidad();
					s.setTotal(Math.round(precioxcantidad * 100.0) / 100.0);
					s.getPelicula().setStock(s.getPelicula().getStock()+1);
				}

				if (s.getCantidad() == 0) {
					// lista nueva de prodcutos
					List<DetalleOrden> ordenesNueva = new ArrayList<DetalleOrden>();

					for (DetalleOrden detalleOrden : detalles) {

						if (detalleOrden.getPelicula().getId_pelicula() != id_pelicula) {
							System.out.println(detalleOrden.getPelicula().getId_pelicula());
							ordenesNueva.add(detalleOrden);
						}

					}

				// poner la nueva lista con los productos restantes

					detalles = ordenesNueva;
					}
				});
			}

		Pelicula pelicula = peliculaServicio.get(id_pelicula);


		pelicula.setStock(pelicula.getStock() + 1);
		peliculaServicio.save(pelicula);
		sumaTotalProductos = detalles.stream().mapToInt(dt -> dt.getCantidad()).sum();
		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();
		orden.setCantidad(sumaTotalProductos);
		orden.setTotal(Math.round(sumaTotal * 100.0) / 100.0);
		model.addAttribute("carrito", detalles);
		model.addAttribute("orden", orden);

		return "redirect:/carrito";

	}
	
	// CERRAR SESION
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(Model model) {

		double sumaTotal = 0;

		int sumaTotalProductos = 0;

		List<DetalleOrden> ordenesNueva = new ArrayList<DetalleOrden>();

		System.out.println(detalles);

		for (DetalleOrden detalle : detalles) {
			Pelicula pelicula = detalle.getPelicula();
			int id_pelicula = pelicula.getId_pelicula();

			System.out.println(pelicula);
			
			int cantidad = detalle.getCantidad();
			System.out.println(cantidad);
			pelicula.setStock(pelicula.getStock() + cantidad);
			System.out.println(pelicula.getStock());
			peliculaServicio.save(pelicula);

		}

		List<DetalleOrden> ordenesVacia = new ArrayList<DetalleOrden>();

		detalles = ordenesVacia;
		orden.setCantidad(sumaTotalProductos);
		orden.setTotal(Math.round(sumaTotal * 100.0) / 100.0);
		model.addAttribute("carrito", detalles);
		model.addAttribute("orden", orden);

		return "redirect:/logout";
	}
	
	
	// IR AL CARRITO
	@GetMapping("/carrito")
	public String getCart(Model model, Authentication authentication) {
		model.addAttribute("carrito", detalles);
		model.addAttribute("orden", orden);
		
		if (authentication != null && authentication.isAuthenticated()) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String emailLogueado = userDetails.getUsername();
			Usuario usuario = usuarioServicio.findByEmail(emailLogueado);
		}
		
		return "carrito";
	}
	
	@GetMapping("/orden")
	public String orden(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		String emailLogueado = userDetail.getUsername();
				
	
		List<Usuario>usuario = usuarioServicio.mostrarPerfiles(emailLogueado);
		model.addAttribute("usuario", usuario);
		
		model.addAttribute("carrito", detalles);
		model.addAttribute("orden", orden);
		
		return "orden";
	}
	
	
	
	// guardar la orden
	@PostMapping("/saveOrder")
	public String saveOrder(@Valid String direccion, String dni,HttpServletRequest request, RedirectAttributes redirectAttributes) {
		
		Date fechaCreacion = new Date();
		orden.setFecha_creacion(fechaCreacion);
		orden.setNumero(ordenServicio.generarNumeroOrden());
		
		
		
		//Obtener email del usuario logeado
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String emailLogueado = userDetail.getUsername();
		
		
		//usuario
		//Usuario usuario =usuarioService.findById( Integer.parseInt(session.getAttribute("idusuario").toString())  ).get();
		List<Usuario> usuario = usuarioServicio.mostrarPerfiles(emailLogueado);
		Usuario usuarioEncontrado = usuario.get(0);
		orden.setUsuario(usuarioEncontrado);
		int idUsuario=usuarioEncontrado.getId_usuario();
		orden.setDireccion(direccion);
		if (usuarioEncontrado.getDireccion()==null || usuarioEncontrado.getDireccion().isEmpty()) {
			usuarioServicio.actualizarDir(idUsuario, direccion);
		}
		
		if (usuarioEncontrado.getDni()==null || usuarioEncontrado.getDni().isEmpty()) {
			
			boolean dniCorrecto = false;
			String campoDNI = dni;
			String cadenanumeros = campoDNI.substring(0, 8);
			String letra = campoDNI.substring(8);
			int codlet;
			codlet = Integer.parseInt(cadenanumeros) % 23;

			switch (codlet) {
			    case 0:
			        if (letra.equalsIgnoreCase("T")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 1:
			        if (letra.equalsIgnoreCase("R")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 2:
			        if (letra.equalsIgnoreCase("W")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 3:
			        if (letra.equalsIgnoreCase("A")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 4:
			        if (letra.equalsIgnoreCase("G")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 5:
			        if (letra.equalsIgnoreCase("M")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 6:
			        if (letra.equalsIgnoreCase("Y")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 7:
			        if (letra.equalsIgnoreCase("F")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 8:
			        if (letra.equalsIgnoreCase("P")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 9:
			        if (letra.equalsIgnoreCase("D")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 10:
			        if (letra.equalsIgnoreCase("X")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 11:
			        if (letra.equalsIgnoreCase("B")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 12:
			        if (letra.equalsIgnoreCase("N")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 13:
			        if (letra.equalsIgnoreCase("J")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 14:
			        if (letra.equalsIgnoreCase("Z")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 15:
			        if (letra.equalsIgnoreCase("S")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 16:
			        if (letra.equalsIgnoreCase("Q")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 17:
			        if (letra.equalsIgnoreCase("V")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 18:
			        if (letra.equalsIgnoreCase("H")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 19:
			        if (letra.equalsIgnoreCase("L")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 20:
			        if (letra.equalsIgnoreCase("C")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 21:
			        if (letra.equalsIgnoreCase("K")) {
			            dniCorrecto = true;
			        }
			        break;
			    case 22:
			        if (letra.equalsIgnoreCase("E")) {
			            dniCorrecto = true;
			        }
			        break;
			}

			// At this point, dniCorrecto is either true or false, depending on whether the DNI is valid.

	        
	        
			if(dniCorrecto) {
				dni=dni.toUpperCase();
				usuarioServicio.actualizarDni(idUsuario, dni);
			
			}else {
				redirectAttributes.addFlashAttribute("dniError", "Invalid DNI. Please enter a valid DNI.");
				return "redirect:/orden";
			}
		}
		
		
		
		if (orden.getCantidad() == 0) {
			log.info("Carrito vacio");
			//return "/";
			String referer = request.getHeader("Referer");
			return "redirect:" + referer; 
		}else {
			ordenServicio.save(orden);				
			//guardar detalles
			for (DetalleOrden dt:detalles) {
				dt.setOrden(orden);
				detalleOrdenServicio.save(dt);								
			}
			
			///limpiar lista y orden
			orden = new Orden();
			detalles.clear();	
		
			
			return "redirect:/";
		}		
	}
		
	@GetMapping("/detallecompra/{id_orden}")
	public String detalleCompra(@PathVariable int id_orden, HttpSession session, Model model) {
		//logger.info("Id de la orden: {}", id);
		Optional<Orden> orden=ordenServicio.findById(id_orden);
		String numero = orden.get().getNumero();
		Date pedido = orden.get().getFecha_creacion();
		Date entrega = orden.get().getFecha_recibida();
		String direccion = orden.get().getDireccion();
		Double total = orden.get().getTotal();
		
		model.addAttribute("numero", numero);
		model.addAttribute("pedido", pedido);
		model.addAttribute("entrega", entrega);
		model.addAttribute("direccion", direccion);
		model.addAttribute("total", total);
		
		List<DetalleOrden> detalles = detalleOrdenServicio.findByIdOrden(id_orden);
		

		model.addAttribute("detalles", detalles);

		
		//session
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		return "detallecompra";
	}

	
}
