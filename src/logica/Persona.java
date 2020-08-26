package logica;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Persona")
public class Persona  {

	private String documento;
	private String nombre;
	private String apellido;
	private String ciudad;
	private Date nacimiento;
	private String celular;
	private String contrasena;
	private double productos;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public Persona(String documento, String nombre, String apellido, String ciudad, Date nacimiento, String celular,
			String contraseña, double productos) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.nacimiento = nacimiento;
		this.celular = celular;
		this.contrasena = contraseña;
		this.productos = productos;
	}
	public Persona(String documento2, String nombre2, String apellido2, String ciudad2, Date nacimiento2,
			String celular2, String contraseña2, Object object) {
		// TODO Auto-generated constructor stub
	}
	public String getDocumento() {
		return documento;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getCiudad() {
		return ciudad;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	public String getCelular() {
		return celular;
	}
	public String getContraseña() {
		return contrasena;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public void setContraseña(String contraseña) {
		this.contrasena = contraseña;
	}
	public double getProductos() {
		return productos;
	}
	public void setProductos(double productos) {
		this.productos = productos;
	}

	
	
}
