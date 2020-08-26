package logica;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Producto")
public class Producto {
	
	private String nombre;
	private int stock;
	private double precio;
	private String codigo;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String nombre, int stock, double precio, String codigo) {
		super();
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getStock() {
		return stock;
	}

	public double getPrecio() {
		return precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
