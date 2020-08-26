package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "GestionHistorial")
public class GestionHistorial implements Comparator<Historial>{
	ArrayList<Historial> historiales;

	public GestionHistorial() {

		historiales = new ArrayList<Historial>();
	}
	public void crearHistorial(String[] datos) {
		 String recepcionista = datos[0];
		 String numeroHabitacion = datos[1];
		 String numeroPersonas = datos[2];
		 String precioHabitacion = datos[3];
		 String precioGrupo = datos[4];
		 Historial historial = new Historial(recepcionista, numeroHabitacion, numeroPersonas, precioHabitacion, precioGrupo);
		 historiales.add(historial);
		 Collections.sort(historiales);
	}
	public String[][] mostrarDatos() {
		String[][] datos = new String[historiales.size()][5];
		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = historiales.get(i).getRecepcionista();
			datos[i][1] = historiales.get(i).getNumeroHabitacion();
			datos[i][2] = historiales.get(i).getNumeroPersonas();
			datos[i][3] = historiales.get(i).getPrecioHabitacion();
			datos[i][4] = historiales.get(i).getPrecioGrupo();
		}
		return datos;
	}
	
	@XmlElementWrapper(name = "historiales")
	@XmlElement(name = "Historial")
	
	public ArrayList<Historial> getHistoriales() {
		return historiales;
	}
	public void setHistoriales(ArrayList<Historial> historiales) {
		this.historiales = historiales;
	}
	@Override
	public int compare(Historial e1, Historial e2) {
		int precioE1 = Integer.parseInt(e1.getPrecioGrupo());
		int precioE2 = Integer.parseInt(e2.getPrecioGrupo());
		if(precioE1>precioE2){
            return -1;
        }else if(precioE1>precioE2){
            return 0;
        }else{
            return 1;
        }
	}
}
