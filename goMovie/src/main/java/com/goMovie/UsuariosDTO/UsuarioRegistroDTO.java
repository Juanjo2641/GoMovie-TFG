package com.goMovie.UsuariosDTO;

public class UsuarioRegistroDTO {

	private String nombre;

	private String apellido;
	private String email;
	private String password;

	private int id_usuario;

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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

	public UsuarioRegistroDTO(int id_usuario, String nombre, String apellido, String email, String password) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}

	public UsuarioRegistroDTO(String nombre, String apellido, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}

	public UsuarioRegistroDTO(String email) {
		super();
		this.email = email;
	}

	public UsuarioRegistroDTO() {

	}

}
