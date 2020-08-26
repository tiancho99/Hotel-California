package logica;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Habitacion")
public class Habitacion {

	private String numero;
	private String maximoPersonas;
	private double precioPersona;
	private boolean barra;
	private boolean aire;
	private  boolean television;
	private  boolean jacuzzi;
	private boolean disponible;
	
	public Habitacion() {
		// TODO Auto-generated constructor stub
	}
	
	public Habitacion(String numero, String maximoPersonas, double precioPersona, boolean barra, boolean aire,
			boolean television, boolean jacuzzi, boolean disponible) {
		super();
		this.numero = numero;
		this.maximoPersonas = maximoPersonas;
		this.precioPersona = precioPersona;
		this.barra = barra;
		this.aire = aire;
		this.television = television;
		this.jacuzzi = jacuzzi;
		this.disponible = disponible;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getMaximoPersonas() {
		return maximoPersonas;
	}


	public void setMaximoPersonas(String maximoPersonas) {
		this.maximoPersonas = maximoPersonas;
	}


	public double getPrecioPersona() {
		return precioPersona;
	}


	public void setPrecioPersona(double precioPersona) {
		this.precioPersona = precioPersona;
	}


	public boolean isBarra() {
		return barra;
	}


	public void setBarra(boolean barra) {
		this.barra = barra;
	}


	public boolean isAire() {
		return aire;
	}


	public void setAire(boolean aire) {
		this.aire = aire;
	}


	public boolean isTelevision() {
		return television;
	}


	public void setTelevision(boolean television) {
		this.television = television;
	}


	public boolean isJacuzzi() {
		return jacuzzi;
	}


	public void setJacuzzi(boolean jacuzzi) {
		this.jacuzzi = jacuzzi;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	
}
