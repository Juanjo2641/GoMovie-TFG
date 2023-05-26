package com.goMovie.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "roles")
	public class Rol {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id_rol;
		private String nombre;

		

		public int getId_rol() {
			return id_rol;
		}

		public void setId_rol(int id_rol) {
			this.id_rol = id_rol;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		

		public Rol(int id_rol, String nombre) {
			super();
			this.id_rol = id_rol;
			this.nombre = nombre;
		}

		public Rol() {
			super();
		}

		public Rol(String nombre) {
			super();
			this.nombre = nombre;
		}

		
	}
 
