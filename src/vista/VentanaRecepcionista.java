package vista;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import control.Control;
import crudCliente.CrudCliente;
import crudCliente.CrudPersona;
import crudCliente.VentanaConfirmar;
import crudCliente.VentanaRegistro;
import crudCliente.VentanaReserva;
import crudHabitacion.CrudHabitacion;
import crudHabitacion.CrudHabitacion;
import crudProducto.CrudProducto;
import crudRecepcionista.CrudRecepcionista;

public class VentanaRecepcionista extends JPanel {
	private JTabbedPane jtpPestañasRecepcionista;
	private CrudPersona crudPersona;
	private VentanaPerfil perfilRecepcionista;
	private VentanaReserva ventanaReserva;
	private VentanaConfirmar ventanaConfirmar;
	private CrudHabitacion crudHabitacion;

	public VentanaRecepcionista() {
		setLayout(null);

		inicializar();
		caracteristicas();
		agregar();
	}

	private void inicializar() {
		jtpPestañasRecepcionista = new JTabbedPane();
		perfilRecepcionista = new VentanaPerfil();
		ventanaReserva = new VentanaReserva();
		ventanaConfirmar = new VentanaConfirmar();
		crudHabitacion = new CrudHabitacion();
		crudPersona = new CrudPersona();
	}

	private void caracteristicas() {
		 
		jtpPestañasRecepcionista.setBounds(20, 0, 760, 360);
		jtpPestañasRecepcionista.add("perfil", perfilRecepcionista);
		jtpPestañasRecepcionista.add("reserva", ventanaReserva);
		



	}

	private void agregar() {
		add(jtpPestañasRecepcionista);
		
	}
 
	public void asignarControl(Control control) {

		perfilRecepcionista.getBtnCerrarCesion().addActionListener(control);
		
		ventanaReserva.getBtnAsignar().addActionListener(control);
		ventanaReserva.getBtnSalir().addActionListener(control);
		ventanaReserva.getJcBarraProductos().addActionListener(control);
		ventanaReserva.getJcAire().addActionListener(control);
		ventanaReserva.getJcTelevision().addActionListener(control);
		ventanaReserva.getJcJacuzzi().addActionListener(control);
		ventanaReserva.getJcReestablecer().addActionListener(control);
		
		ventanaConfirmar.getBtnRegistrar().addActionListener(control);
		ventanaConfirmar.getBtnModificarCliente().addActionListener(control);
		ventanaConfirmar.getBtnEliminarCliente().addActionListener(control);
		ventanaConfirmar.getBtnVerCliente().addActionListener(control);
		ventanaConfirmar.getBtnSalir().addActionListener(control);
		
		crudPersona.asignarControl(control);
		
		
	}

	public void iniciar(String seccion) {

		 
		
	}

	public void salir(String seccion) {
		if (seccion.equals("reserva")) {
			jtpPestañasRecepcionista.setComponentAt(1, ventanaConfirmar);
			repaint();

		}
		if (seccion.equals("confirmar")) {
			jtpPestañasRecepcionista.setComponentAt(1, crudPersona);
			crudPersona.iniciar(seccion);
			repaint();
 
		}
		if (seccion.equals("salirConfirmarCliente")) {
			jtpPestañasRecepcionista.setComponentAt(1, ventanaReserva);
			repaint();

		}
		if (seccion.equals("modificarCliente")) {
			jtpPestañasRecepcionista.setSize( 760, 660);
			jtpPestañasRecepcionista.setComponentAt(1, crudPersona);
			crudPersona.iniciar(seccion);
			repaint();
		}
		if (seccion.equals("salirCrudCliente")) {
			jtpPestañasRecepcionista.setSize(760, 360);
			jtpPestañasRecepcionista.setComponentAt(1, ventanaConfirmar);
		}
		
		
		
	}

	public void escribir(String[][] datos, String seccion) {

		if (seccion.equals("reserva")) {
			ventanaReserva.getModeloTabla().setRowCount(0);
			for (int i = 0; i < datos.length; i++) {
				ventanaReserva.getModeloTabla().addRow(datos[i]);
				
			}
		}	
		if (seccion.equals("asignarHabitacion")) {
			// numero,  maximoPersonas,  precioPersona,  barra,  aire,  television,  jacuzzi,  disponible
			ventanaConfirmar.getNumeroHabitacion().setText(datos[0][0]);
			ventanaConfirmar.getNumeroPersonas().setText(datos[0][1]);
			ventanaConfirmar.getBarra().setText(datos[0][3]);
			ventanaConfirmar.getAire().setText(datos[0][4]);
			ventanaConfirmar.getTelevision().setText(datos[0][5]);
			ventanaConfirmar.getJacuzzi().setText(datos[0][6]);
		}
		if(seccion.equals("modificarCliente")){
			crudPersona.escribir(datos, seccion);
		}

	}

	public String[] leer(String seccion) {
		String[] datos = null;
		if (seccion.equals("asignarHabitacion")) {
			datos = new String[1];
			int x = ventanaReserva.getJtbTablaHabitaciones().getSelectedRow();
			Object obj= ventanaReserva.getModeloTabla().getValueAt(x, 0);
			datos[0] = String.valueOf(obj);
			
		}
		if (seccion.equals("reserva")) {
			datos = new String[4];
			datos[0] = String.valueOf(ventanaReserva.getJcBarraProductos().isSelected());
			datos[1] = String.valueOf(ventanaReserva.getJcAire().isSelected());
			datos[2] = String.valueOf(ventanaReserva.getJcTelevision().isSelected());
			datos[3] = String.valueOf(ventanaReserva.getJcJacuzzi().isSelected());
		}
		if (seccion.equals("registrarCliente")) {
			
//			String documento, String nombre, String apellido, String ciudad, Date nacimiento, String celular,String contraseña
			
			datos =crudPersona.leer(seccion);
			datos[7] = ventanaConfirmar.getNumeroHabitacion().getText();
			datos[8] = ventanaConfirmar.getNumeroPersonas().getText();
			datos[9] = perfilRecepcionista.getDocumento().getText();
				
		}
		if (seccion.equals("modificarCliente")) {
			datos = new String[1];
			datos[0] = ventanaConfirmar.getNumeroHabitacion().getText();
			
		}
		if (seccion.equals("borrarCliente")) {
			datos = new String[1];
			datos[0] = ventanaConfirmar.getNumeroHabitacion().getText();
		}
		return datos;
	}
	
	public void dibujar(String[] datos, String seccion) {
		perfilRecepcionista.getNombre().setText(datos[0]);
		perfilRecepcionista.getApellido().setText(datos[1]);
		perfilRecepcionista.getDocumento().setText(datos[2]);
	}
	public void borrar(String seccion) {
		if (seccion.equals("registrar")) {
			crudPersona.borrar(seccion);
		}
		
	}

	
	public JTabbedPane getJtpPestañasRecepcionista() {
		return jtpPestañasRecepcionista;
	}

	public VentanaPerfil getPerfilRecepcionista() {
		return perfilRecepcionista;
	}

	public VentanaReserva getVentanaReserva() {
		return ventanaReserva;
	}

	public VentanaConfirmar getConfirmarRegistro() {
		return ventanaConfirmar;
	}

	public CrudHabitacion getCrudHabitaciones() {
		return crudHabitacion;
	}





	
	

	

	
	
}
