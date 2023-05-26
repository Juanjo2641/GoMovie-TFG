package com.goMovie.Modelo;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.goMovie.UsuariosDTO.UsuarioRegistroDTO;





@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String dni;
	private String direccion;
	private boolean enabled;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles", 
			joinColumns = @JoinColumn(name = "id_usuario"), 
			inverseJoinColumns = @JoinColumn(name = "id_rol"))
	
	private Collection<Rol> roles;
	


	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido, String password, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		
		
		
	}

	public Usuario( String nombre,  String apellido, String email, String password,  Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		
		
		
		
		this.roles = roles;
	}

	public Usuario(int id_usuario, String email, String password, String dni, String nombre, String apellido, String direccion) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.password = password;
		this.email = email;	
		this.dni = dni;		
		this.apellido = apellido;
		this.direccion = direccion;
	}
	
	

	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", email=" + email + ", password=" + password + ", dni=" + dni
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + "]";
	}

		
}
