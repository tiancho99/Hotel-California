package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GestionReserva") 
public class GestionReserva {
	ArrayList<Reserva> reservas;
	GestionHabitacion gestionHabitacion;
	GestionRecepcionista gestionRecepcionista;
	GestionAdmin gestionAdmin; 
	GestionProducto gestionProducto;
	GestionHistorial gestionHistorial;
	 
	public GestionReserva() {
//		ArrayList<Persona> per = new ArrayList<>();
//		Persona persona = new Persona("1", "1", "1", "1", null, "1", "1", new ArrayList<Producto>());
//		per.add(persona);
//		Reserva reserva = new Reserva(per, null, null, 0, 0, 0, null, null, null);
	reservas = new ArrayList<Reserva>();
//	reservas.add(reserva);
	gestionHabitacion = new GestionHabitacion();
	gestionRecepcionista = new GestionRecepcionista();
	gestionAdmin = new GestionAdmin();
	gestionProducto = new GestionProducto();
	gestionHabitacion = new GestionHabitacion();
	gestionHistorial = new GestionHistorial();
	}
	public int buscarReserva(String numero) {
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getHabitacion().getNumero().equals(numero)) {
				return i;
			}
		}
		return -1;
		
	}
	public  String[][] mostrarDatos(String[] numero) {
//		String documento, String nombre, String apellido, String ciudad, Date nacimiento, String celular,String contraseña
		
		int posicion = buscarReserva(numero[0]);
		String[][] datos = new String[reservas.get(posicion).getClientes().size()][7]; 
		SimpleDateFormat formato = new SimpleDateFormat("d/MM/yyyy");
		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = reservas.get(posicion).getClientes().get(i).getDocumento();
			datos[i][1] = reservas.get(posicion).getClientes().get(i).getNombre();
			datos[i][2] = reservas.get(posicion).getClientes().get(i).getApellido();
			datos[i][3] = reservas.get(posicion).getClientes().get(i).getCiudad();
			datos[i][4] = formato.format(reservas.get(posicion).getClientes().get(i).getNacimiento());
			datos[i][5] = reservas.get(posicion).getClientes().get(i).getCelular();
			datos[i][6] = reservas.get(posicion).getClientes().get(i).getContraseña();
		}
		return datos;
		
	}
	
	

	public void crearReserva(String[] datos) throws NullPointerException, ParseException {
		int posicion = 0;
		//		ArrayList<Persona> clientes, Habitacion habitacion, Recepcionista recepcionista, int numeroPersonas,
		//		double totalProducto, double valorGrupal, double adicionales, Date fechaIngreso, Date fechaSalida
		Habitacion habitacion = null;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
				habitacion = gestionHabitacion.getHabitaciones().get(gestionHabitacion.buscarHabitacion(datos[7]));
				
		if (habitacion.isDisponible()) {
			personas.add(crearPersona(datos));
			Recepcionista recepcionista = null;
			
					recepcionista = gestionRecepcionista.getRecepcionistas().get(gestionRecepcionista.buscarRecepcionista(datos[9]));
				
			habitacion.setDisponible(false);
			gestionHabitacion.getHabitaciones().get(gestionHabitacion.buscarHabitacion(datos[7])).setDisponible(false);
			Date fechaIngreso = new Date();
			Reserva reserva = new Reserva(personas, habitacion, recepcionista, 0, 0, 0, fechaIngreso, fechaIngreso, datos[7]);
			reservas.add(reserva);
			recepcionista.setNumeroVentas(recepcionista.getNumeroVentas()+1);
JOptionPane.showMessageDialog(null, "reserva creada" );
		}else {
			
					posicion = buscarReserva(datos[7]);
			
//			System.out.println(reservas.get(posicion).getNumeroPersonas()+Integer.parseInt(reservas.get(posicion).getHabitacion().getMaximoPersonas()));
			if(reservas.get(posicion).getClientes().size() < Integer.parseInt(reservas.get(posicion).getHabitacion().getMaximoPersonas())) {
			for (int i = 0; i < reservas.size(); i++) {
				if (reservas.get(i).getHabitacion().getNumero().equals(datos[7])) {
					reservas.get(i).getClientes().add(crearPersona(datos));
					JOptionPane.showMessageDialog(null, "cliente agregado");
				}
			}
			}else {
				JOptionPane.showMessageDialog(null, "la habitacion esta llena, no puede agregar mas clientes");
			}
			

		}
	}





	private Persona crearPersona(String[] datos) throws NullPointerException, ParseException{
		SimpleDateFormat parseador = new SimpleDateFormat("d/MM/yyyy");
		// documento,  nombre,  apellido,  ciudad,  nacimiento, celular,  contraseña,  direccion
		
		String documento = datos[0];
		String nombre = datos[1];
		String apellido = datos[2];
		String ciudad = datos[3];
		Date nacimiento = parseador.parse(datos[4]);
		String celular = datos[5];
		String contraseña = datos[6];
			
		Persona persona = new Persona(documento, nombre, apellido, ciudad, nacimiento, celular, contraseña, 0);
		
		
		return persona;
		
}


public void modificarCliente(String[] datos) {
	int posicion = buscarReserva(datos[7]);
	int selectedRow = Integer.parseInt(datos[10]);
	// documento,  nombre,  apellido,  ciudad,  nacimiento, celular,  contraseña,  
	if (!datos[0].equals("")) {
		reservas.get(posicion).getClientes().get(selectedRow).setDocumento(datos[0]);
	}
	if (!datos[1].equals("")) {
		reservas.get(posicion).getClientes().get(selectedRow).setNombre(datos[1]);
	}
	if (!datos[2].equals("")) {
		reservas.get(posicion).getClientes().get(selectedRow).setApellido(datos[2]);
	}
	if (!datos[3].equals("")) {
		reservas.get(posicion).getClientes().get(selectedRow).setCiudad(datos[3]);
	}
	if (!datos[4].equals("")) {
		SimpleDateFormat parseador = new SimpleDateFormat("d/MM/yyyy");
		Date date;
		try {
			date = parseador.parse(datos[4]);
			reservas.get(posicion).getClientes().get(selectedRow).setNacimiento(date);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "fecha invalida");
		}
	
	}
	if (!datos[5].equals("")) {
		reservas.get(posicion).getClientes().get(selectedRow).setCelular(datos[5]);
	}
	if (!datos[6].equals("")) {
		reservas.get(posicion).getClientes().get(selectedRow).setContraseña(datos[6]);
	}
	
	
}
public void checkOut(String[] datos) {
	int posicion = buscarReserva(datos[0]);
	int habitacion = gestionHabitacion.buscarHabitacion(datos[0]);
	if(!gestionHabitacion.getHabitaciones().get(habitacion).isDisponible()) {
		gestionHabitacion.getHabitaciones().get(habitacion).setDisponible(true);
	String recepcionista = reservas.get(posicion).getRecepcionista().getNombre();
	String numeroHabitacion = reservas.get(posicion).getHabitacion().getNumero();
	int PersonasRegistradas = reservas.get(posicion).getClientes().size();
	double precioPersona = valorPersona(posicion);
	double precioGrupal = PersonasRegistradas*precioPersona;
	long dias = calcularDias(reservas.get(posicion));
	long total = (long) (dias*precioGrupal);
	double productos = valorProducto(posicion);
	double extra = valorExtra(posicion);
	long totalGlogal = (long) (total + productos + extra);
	JOptionPane.showMessageDialog(null, "recepcionista: " +  recepcionista +
				"\nhabitacion: " + numeroHabitacion + "\nnumero de clientes: " + PersonasRegistradas + 
				"\nprecio por persona: " + precioPersona + "\nprecio Grupal: " + precioGrupal +
				"\nprecio productos " + productos + "\nprecio adicionales"+ extra + 
				"\ndias de hospedaje" + dias + "\nprecio total por dias" + total + 
				"\ntotal global " + totalGlogal);
//	recepcionista, numeroHabitacion, numeroPersonas, precioHabitacion, precioGrupo
		crearHistorial(recepcionista, numeroHabitacion, PersonasRegistradas, precioPersona, precioGrupal);
		reservas.remove(posicion);
	}
} 
private void crearHistorial(String recepcionista, String numeroHabitacion, int personasRegistradas,
		double precioPersona, double precioGrupal) {
	String[] datos = new String[5];
	datos[0] = recepcionista;
	datos[1] = numeroHabitacion;
	datos[2] = String.valueOf(personasRegistradas);
	datos[3] = String.valueOf(precioPersona);
	datos[4] = String.valueOf(precioGrupal);
	gestionHistorial.crearHistorial(datos);
	
	
}
private double valorPersona(int posicion) {
	double valor = 0;
	valor = reservas.get(posicion).getHabitacion().getPrecioPersona();
	return valor;
}
private double valorExtra(int posicion) {
//	int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
	double valor = 0;
	Date fechaSalida = new Date();
	for (int i = 0; i < reservas.get(posicion).getClientes().size(); i++) {
		Date fechaNacimiento = reservas.get(posicion).getClientes().get(i).getNacimiento();
		int dias=(int) ((fechaSalida.getTime()-fechaNacimiento.getTime())/86400000);
		 if ((dias/365) < 18) {
			valor = 20000;
		}
	}
	return valor;
}


private double valorProducto(int posicion) {
	double valor = 0;
	for (int i = 0; i < reservas.get(posicion).getClientes().size(); i++) {
		 valor = valor + reservas.get(posicion).getClientes().get(i).getProductos();
	}
	return valor;
}


	private long calcularDias(Reserva reserva) {
	
	Date fechaSalida = new Date();
	Date fechaIngreso = reserva.getFechaIngreso();
	reserva.setFechaSalida(fechaSalida);
	long dias=(int) ((fechaSalida.getTime()-fechaIngreso.getTime())/86400000);
	return dias;
}
	public GestionHabitacion getGestionHabitacion() {
		return gestionHabitacion;
	}

	
	public boolean validarSecion(String[] datosInicio) {
		for (int i = 0; i < reservas.size(); i++) {
			for (int j = 0; j < reservas.get(i).getClientes().size(); j++) {
				if (reservas.get(i).getClientes().get(j).getContraseña().equals(datosInicio[1]) && 
						reservas.get(i).getClientes().get(j).getDocumento().equals(datosInicio[0])) {
					return true;
				}
			}
		}
		return false;
	}
	public String[] mostrarcliente(String datosInicio) {
		// documento,  nombre,  apellido,  ciudad,  nacimiento, celular,  contraseña,  
		String[] datos = new String[8];
		SimpleDateFormat formato = new SimpleDateFormat("d/MM/yyyy");
		for (int i = 0; i < reservas.size(); i++) {
			for (int j = 0; j < reservas.get(i).getClientes().size(); j++) {
				if (reservas.get(i).getClientes().get(j).getDocumento().equals(datosInicio)){
					datos[0] = reservas.get(i).getClientes().get(j).getDocumento();
					datos[1] = reservas.get(i).getClientes().get(j).getNombre();
					datos[2] = reservas.get(i).getClientes().get(j).getApellido();
					datos[3] = reservas.get(i).getClientes().get(j).getCiudad();
					datos[4] = formato.format(reservas.get(i).getClientes().get(j).getNacimiento());
					datos[5] = reservas.get(i).getClientes().get(j).getCelular();
					datos[6] = reservas.get(i).getClientes().get(j).getContraseña();
					datos[7] = String.valueOf(reservas.get(i).getClientes().get(j).getProductos());
				}
			}
		}
		return datos;
	}
	public void AsignarProducto(String[] producto, String[] documento) {
		System.out.println(producto[1]);
		System.out.println(producto[2]);
		Double cuenta  = Double.parseDouble(producto[1])*Double.parseDouble(producto[2]);
		for (int i = 0; i < reservas.size(); i++) {
			for (int j = 0; j < reservas.get(i).getClientes().size(); j++) {
				if (reservas.get(i).getClientes().get(j).getDocumento().equals(documento[0])){
					Double cuentaAnterior = reservas.get(i).getClientes().get(j).getProductos();
					reservas.get(i).getClientes().get(j).setProductos(cuentaAnterior+cuenta);
					System.out.println(reservas.get(i).getClientes().get(j).getProductos());
				}
			}
		}
		
	}
	@XmlElementWrapper(name = "reservas")
	@XmlElement(name = "Reserva")
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas; 
	}
	public GestionRecepcionista getGestionRecepcionista() {
		return gestionRecepcionista;
	}
	public GestionAdmin getGestionAdmin() {
		return gestionAdmin;
	}
	public GestionProducto getGestionProducto() {
		return gestionProducto;
	}
	
	public GestionHistorial getGestionHistorial() {
		return gestionHistorial;
	}
	public void setGestionHabitacion(GestionHabitacion gestionHabitacion) {
		this.gestionHabitacion = gestionHabitacion;
	}
	public void setGestionRecepcionista(GestionRecepcionista gestionRecepcionista) {
		this.gestionRecepcionista = gestionRecepcionista;
	}
	public void setGestionAdmin(GestionAdmin gestionAdmin) {
		this.gestionAdmin = gestionAdmin;
	}
	public void setGestionProducto(GestionProducto gestionProducto) {
		this.gestionProducto = gestionProducto;
	}
	public void setGestionHistorial(GestionHistorial gestionHistorial) {
		this.gestionHistorial = gestionHistorial;
	}







}
