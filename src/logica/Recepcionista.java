package logica;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Recepcionista")
public class Recepcionista extends Persona implements Comparable<Recepcionista> {
	
	private int numeroVentas;

	public Recepcionista() {
		// TODO Auto-generated constructor stub
	}
	
	public Recepcionista(String documento, String nombre, String apellido, String ciudad, Date nacimiento,
			String celular, String contraseña, int numeroVentas) {
		super(documento, nombre, apellido, ciudad, nacimiento, celular, contraseña, 0);
		this.numeroVentas = numeroVentas;
	}

	public int getNumeroVentas() {
		return numeroVentas;
	}

	public void setNumeroVentas(int numeroVentas) {
		this.numeroVentas = numeroVentas;
	}

	@Override
	public int compareTo(Recepcionista o) {

		if (numeroVentas < o.numeroVentas) {
            return -1;
        }
        if (numeroVentas > o.numeroVentas) {
            return 1;
        }		return 0;
	}

	

	
}
