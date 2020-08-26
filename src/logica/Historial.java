package logica;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Historial")
public class Historial implements Comparable<Historial>{
private String recepcionista;
private String numeroHabitacion;
private String numeroPersonas;
private String precioHabitacion;
private String precioGrupo;

public Historial() {
	// TODO Auto-generated constructor stub
}

public Historial(String recepcionista, String numeroHabitacion, String numeroPersonas, String precioHabitacion,
		String precioGrupo) {
	super();
	this.recepcionista = recepcionista;
	this.numeroHabitacion = numeroHabitacion;
	this.numeroPersonas = numeroPersonas;
	this.precioHabitacion = precioHabitacion;
	this.precioGrupo = precioGrupo;
}
public String getRecepcionista() {
	return recepcionista;
}
public void setRecepcionista(String recepcionista) {
	this.recepcionista = recepcionista;
}
public String getNumeroHabitacion() {
	return numeroHabitacion;
}
public void setNumeroHabitacion(String numeroHabitacion) {
	this.numeroHabitacion = numeroHabitacion;
}
public String getNumeroPersonas() {
	return numeroPersonas;
}
public void setNumeroPersonas(String numeroPersonas) {
	this.numeroPersonas = numeroPersonas;
}
public String getPrecioHabitacion() {
	return precioHabitacion;
}
public void setPrecioHabitacion(String precioHabitacion) {
	this.precioHabitacion = precioHabitacion;
}
public String getPrecioGrupo() {
	return precioGrupo;
}
public void setPrecioGrupo(String precioGrupo) {
	this.precioGrupo = precioGrupo;
}

@Override
public int compareTo(Historial o) {
	// TODO Auto-generated method stub
	return 0;
}



}
