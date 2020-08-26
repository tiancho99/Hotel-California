package logica;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "GestionHabitacion")
public class GestionHabitacion {

	ArrayList<Habitacion> habitaciones;

	public GestionHabitacion() {
		habitaciones = new ArrayList<Habitacion>();
		
	}
	// numero,  maximoPersonas,  precioPersona,  barra,  aire,  television,  jacuzzi,  disponible
	public int buscarHabitacion(String numero) {
		for (int i = 0; i < habitaciones.size(); i++) {
			if (habitaciones.get(i).getNumero().equals(numero)) {
				return i;
			}
		}
		return -1;
		
	}
	public void crearHabitacion(String[] datos) {
		try {
		String numero = datos[0];
		String maximoPersonas = datos[1];
		double precioPersona = Double.parseDouble(datos[2]);
		boolean barra = Boolean.parseBoolean(datos[3]);
		boolean aire = Boolean.parseBoolean(datos[4]);
		boolean television = Boolean.parseBoolean(datos[5]);
		boolean jacuzzi = Boolean.parseBoolean(datos[6]);
		
		Habitacion habitacion = new Habitacion(numero, maximoPersonas, precioPersona, barra, aire, television, jacuzzi, true);
		habitaciones.add(habitacion);
		JOptionPane.showMessageDialog(null, "habitacion creada");
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "valor invalido");
		}
	}

	public String[][] mostrarDatos(String seccion, String[] continuar) {
		String[][] datos = null;
		if(seccion.equals("mostrar")) {
			datos = new String[habitaciones.size()][8];
			for(int i = 0; i < habitaciones.size(); i++) {
				datos[i][0] = habitaciones.get(i).getNumero();
				datos[i][1] = habitaciones.get(i).getMaximoPersonas();
				datos[i][2] = String.valueOf(habitaciones.get(i).getPrecioPersona());
				datos[i][3] = String.valueOf(habitaciones.get(i).isBarra());
				datos[i][4] = String.valueOf(habitaciones.get(i).isAire());
				datos[i][5] = String.valueOf(habitaciones.get(i).isTelevision());
				datos[i][6] = String.valueOf(habitaciones.get(i).isJacuzzi());
				datos[i][7] = String.valueOf(habitaciones.get(i).isDisponible());
			}
		}
		if (seccion.equals("filtrarBarra")) {
			datos = filtrar(continuar);
		}
		if (seccion.equals("asignarHabitacion")) {
			datos = new String[1][8];
			for(int i = 0; i < habitaciones.size(); i++) {
				if (habitaciones.get(i).getNumero().equals(continuar[0])) {
				datos[0][0] = habitaciones.get(i).getNumero();
				datos[0][1] = habitaciones.get(i).getMaximoPersonas();
				datos[0][2] = String.valueOf(habitaciones.get(i).getPrecioPersona());
				datos[0][3] = String.valueOf(habitaciones.get(i).isBarra());
				datos[0][4] = String.valueOf(habitaciones.get(i).isAire());
				datos[0][5] = String.valueOf(habitaciones.get(i).isTelevision());
				datos[0][6] = String.valueOf(habitaciones.get(i).isJacuzzi());
				datos[0][7] = String.valueOf(habitaciones.get(i).isDisponible());
			}
			}
		}
		return datos;
	}

	public void borrarProducto(String[] datos) {
		int posicion = Integer.parseInt(datos[0]);
		habitaciones.remove(posicion);
	}

	public void actualizarDatos(String[] datos) {
		try {
			int posicion = Integer.parseInt(datos[0]);
			String numero = datos[1];
			String maximoPersonas = datos[2];
			double precioPersona = 0;
			boolean barra = Boolean.parseBoolean(datos[4]);
			boolean aire = Boolean.parseBoolean(datos[5]);
			boolean television = Boolean.parseBoolean(datos[6]);
			boolean jacuzzi = Boolean.parseBoolean(datos[7]);
			if (!datos[3].equals("")) {
				precioPersona = Double.parseDouble(datos[3]);
			}
			if (!numero.equals("")) {
				habitaciones.get(posicion).setNumero(numero);
			}
			if (!maximoPersonas.equals("")) {
				habitaciones.get(posicion).setMaximoPersonas(maximoPersonas);
			}
			habitaciones.get(posicion).setBarra(barra);
			habitaciones.get(posicion).setAire(aire);
			habitaciones.get(posicion).setTelevision(television);
			habitaciones.get(posicion).setJacuzzi(jacuzzi);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "valor invalido");
		}catch (ArrayIndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(null, "seleccione la habitacion que desea modificar");
		}

	}


	private String[][] filtrar(String[] continuar) {
		ArrayList<Habitacion> habitacionesFiltradas = new ArrayList<Habitacion>();

		for (int i = 0; i < habitaciones.size(); i++) {
			if (habitaciones.get(i).isBarra() &&  Boolean.parseBoolean(continuar[0])) {
				habitacionesFiltradas.add(habitaciones.get(i));
//				System.out.println(habitaciones.get(i).getNumero()+" "+habitaciones.get(i).isBarra());
			}
			if (habitaciones.get(i).isAire() &&  Boolean.parseBoolean(continuar[1])) {
				habitacionesFiltradas.add(habitaciones.get(i));
			}
			if (habitaciones.get(i).isTelevision() &&  Boolean.parseBoolean(continuar[2])) {
				habitacionesFiltradas.add(habitaciones.get(i));
			}
			if (habitaciones.get(i).isJacuzzi() &&  Boolean.parseBoolean(continuar[3])) {
				habitacionesFiltradas.add(habitaciones.get(i));
			}
		}


		return parseArray(habitacionesFiltradas);
	}




	
	private String[][] parseArray(ArrayList<Habitacion> habitacionesFiltradas) {
		String[][] datos = new String[habitacionesFiltradas.size()][8];
		for (int i = 0; i < habitacionesFiltradas.size(); i++) {
			datos[i][0] = habitacionesFiltradas.get(i).getNumero();
			datos[i][1] = habitacionesFiltradas.get(i).getMaximoPersonas();
			datos[i][2] = String.valueOf(habitacionesFiltradas.get(i).getPrecioPersona());
			datos[i][3] = String.valueOf(habitacionesFiltradas.get(i).isBarra());
			datos[i][4] = String.valueOf(habitacionesFiltradas.get(i).isAire());
			datos[i][5] = String.valueOf(habitacionesFiltradas.get(i).isTelevision());
			datos[i][6] = String.valueOf(habitacionesFiltradas.get(i).isJacuzzi());
			datos[i][7] = String.valueOf(habitacionesFiltradas.get(i).isDisponible());
		}
		return datos;
	}

	@XmlElementWrapper(name = "habitaciones")
	@XmlElement(name = "Habitacion")
	
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
}
