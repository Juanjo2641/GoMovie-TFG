package com.goMovie.Modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private Date fecha_creacion;
    private Date fecha_recibida;
    private int cantidad;
    private double total;
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id_cliente")
    private Usuario usuario;

    public Orden() {
        super();
    }

    public Orden(int id, String numero, Date fecha_creacion, Date fecha_recibida, double total) {
        super();
        this.id = id;
        this.numero = numero;
        this.fecha_creacion = fecha_creacion;
        this.fecha_recibida = fecha_recibida;
        this.total = total;
    }

    public Orden(String numero, Usuario usuario, Date fecha_creacion, Date fecha_recibida, int cantidad, double total) {
        super();

        this.numero = numero;
        this.usuario = usuario;
        this.fecha_creacion = fecha_creacion;
        this.fecha_recibida = fecha_recibida;
        this.cantidad = cantidad;
        this.total = total;
    }


    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_recibida() {
		return fecha_recibida;
	}

	public void setFecha_recibida(Date fecha_recibida) {
		this.fecha_recibida = fecha_recibida;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	@Override
    public String toString() {
        return "Orden [id=" + id + ", numero=" + numero + ", fecha_creacion=" + fecha_creacion + ", fecha_recibida="
                + fecha_recibida + ", cantidad=" + cantidad + ", total=" + total + ", direccion=" + direccion
                + ", usuario=" + usuario + "]";
    }


}
