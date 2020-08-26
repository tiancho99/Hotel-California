package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Reserva")
public class Reserva {

	private Date fechaIngreso;
	private Date fechaSalida;
	private double totalProducto;
	private double valorGrupal;
	private double adicionales; 
	private Recepcionista recepcionista;
	private Habitacion habitacion; 
	private ArrayList<Persona> clientes;
	private String codigo;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}
	
	public Reserva(ArrayList<Persona> clientes, Habitacion habitacion, Recepcionista recepcionista,
			double totalProducto, double valorGrupal, double adicionales, Date fechaIngreso, Date fechaSalida, String cosigo) {
		super();
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.totalProducto = totalProducto;
		this.valorGrupal = valorGrupal;
		this.adicionales = adicionales;
		this.recepcionista = recepcionista;
		this.habitacion = habitacion;
		this.clientes = clientes;
		this.codigo = codigo;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public double getTotalProducto() {
		return totalProducto;
	}
	public void setTotalProducto(double totalProducto) {
		this.totalProducto = totalProducto;
	}
	public double getValorGrupal() {
		return valorGrupal;
	}
	public void setValorGrupal(double valorGrupal) {
		this.valorGrupal = valorGrupal;
	}
	public double getAdicionales() {
		return adicionales;
	}
	public void setAdicionales(double adicionales) {
		this.adicionales = adicionales;
	}
	public Recepcionista getRecepcionista() {
		return recepcionista;
	}
	public void setRecepcionista(Recepcionista recepcionista) {
		this.recepcionista = recepcionista;
	}
	public Habitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	public ArrayList<Persona> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Persona> clientes) {
		this.clientes = clientes;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
}
