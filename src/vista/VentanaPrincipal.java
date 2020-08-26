package vista;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import control.Control;
import crudProducto.CrudProducto;

public class VentanaPrincipal extends JFrame implements Acciones{
	VentanaLogin ventanaLogin;
	VentanaRecepcionista ventanaRecepcionista;
	VentanaAdmin ventanaAdmin;
	VentanaCliente ventanaCliente;
	
	public VentanaPrincipal() {

		setTitle("HOTEL CALIFORNIA");
		setBounds(200, 10, 500, 300);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		inicializar();
		caracteristicas();
		agregar();
		
	}

	private void inicializar() {
		ventanaLogin = new VentanaLogin();
		ventanaRecepcionista = new VentanaRecepcionista();
		ventanaAdmin = new VentanaAdmin();
		ventanaCliente = new VentanaCliente();
		
	}

	private void caracteristicas() {
		
	}

	private void agregar() {
		add(ventanaLogin);
	}
	
	
//CONTROL-------------------------------------------------
	
	public void asignarControl(Control control) {
		ventanaLogin.getBtnLogIn().addActionListener(control);
		ventanaRecepcionista.asignarControl(control);
		ventanaAdmin.asignarControl(control);
		ventanaCliente.asignarControl(control);
	}
	
	
//METODOS DE INTRFAZ--------------------------------------
	
	@Override
	public void iniciar(String seccion) {
		if(seccion.equals("secionRecepcionista")) {
			setSize(800, 410);
			ventanaRecepcionista.setVisible(true);
			add(ventanaRecepcionista);
			repaint();

		}
		if(seccion.equals("secionPersona")) {
			setSize(500,500);
			ventanaCliente.setVisible(true);
			add(ventanaCliente);
			repaint();

		}
		if(seccion.equals("secionAdmin")) {
			ventanaAdmin.setVisible(true);
			add(ventanaAdmin);
			setSize(700, 410);
			repaint();

		}
		if (seccion.equals("iniciarSecion")) {
			setSize(500, 300);
			ventanaLogin.setVisible(true);
			add(ventanaLogin);
			repaint();

		}
		if(seccion.equals("crearProducto") || seccion.equals("modificarProducto")
				|| seccion.equals("crearRecepcionista") || seccion.equals("modificarRecepcionista")
				|| seccion.equals("crearHabitacion") || seccion.equals("modificarHabitacion") 
				|| seccion.equals("verHabitacion")) {
			setSize(710, 700);
			ventanaAdmin.iniciar(seccion);
			repaint();
 
		}
		if (seccion.equals("menuProducto") || seccion.equals("menuRecepcionista") || seccion.equals("menuHabitacion") || seccion.equals("verHistorial")) {
			setSize(700, 410);
			ventanaAdmin.iniciar(seccion);
			repaint();

		}
		if (seccion.equals("confirmar")) {
			ventanaRecepcionista.iniciar(seccion);
			repaint();

		}
		if (seccion.equals("mas") || seccion.equals("menos")) {
			ventanaCliente.iniciar(seccion);
		}
		


	}

	@Override
	public void salir(String seccion) {
		if (seccion.equals("iniciarSecion")) {
			ventanaLogin.setVisible(false);
			remove(ventanaLogin);
			repaint();
			
		} 
		if (seccion.equals("cerrarSecion")) {
			ventanaRecepcionista.setVisible(false);
			ventanaAdmin.setVisible(false);
			ventanaCliente.setVisible(false);
			remove(ventanaCliente);
			remove(ventanaAdmin);
			remove(ventanaRecepcionista);
			repaint();
 
		}
		if(seccion.equals("menuProducto") || seccion.equals("menuHabitacion") || seccion.equals("salirVerHistorial")) {
			setSize(710, 410);
			ventanaAdmin.salir(seccion);
			repaint(); 

			
		}
		 if (seccion.equals("reserva") || seccion.equals("confirmar") || seccion.equals("salirConfirmarCliente")
				 || seccion.equals("salirCrudCliente")) {
			 setSize(800, 410);
			ventanaRecepcionista.salir(seccion);
			repaint();

		}
		 if (seccion.equals("modificarCliente")) {
			setSize(800, 700);
			 ventanaRecepcionista.salir(seccion);
		}
		
		
	}

	@Override
	public void escribir(String[][] datos, String seccion) {
		if (seccion.equals("modificarProducto") || seccion.equals("modificarHabitacion") || seccion.equals("modificarRecepcionista") 
				|| seccion.equals("verHistorial")) {
			
			ventanaAdmin.escribir(datos, seccion);
		}
		if (seccion.equals("reserva") || seccion.equals("asignarHabitacion") || seccion.equals("modificarCliente")) {
			ventanaRecepcionista.escribir(datos, seccion);
		}
		if(seccion.equals("mostrarProducto")) {
			ventanaCliente.escribir(datos, seccion);
		}
		
	}

	@Override
	public String[] leer(String seccion) {
		String[] datos= null;
		if (seccion.equals("iniciarSecion")) {
			datos = new String[2];
			datos[0] = ventanaLogin.getTxtUsuario().getText();
			datos[1] = ventanaLogin.getTxtContraseña().getText();
		}
		if (seccion.equals("agregarProducto") || seccion.equals("editarProducto") || seccion.equals("borrarProducto")
				|| seccion.equals("agregarHabitacion") || seccion.equals("borrarHabitacion") || seccion.equals("editarHabitacion")
				|| seccion.equals("agregarRecepcionista") || seccion.equals("borrarRecepcionista") || seccion.equals("editarRecepcionista")) {
			datos = ventanaAdmin.leer(seccion);
		}
		if (seccion.equals("asignarHabitacion") || seccion.equals("reserva") || seccion.equals("registrarCliente") || seccion.equals("modificarCliente")) {
			datos = ventanaRecepcionista.leer(seccion);
		}
		if (seccion.equals("secionPersona") || seccion.equals("comprar")) {
			datos = ventanaCliente.leer(seccion);
		}
		
		return datos;
	}

	@Override
	public void dibujar(String[] datos, String seccion) {
		if (seccion.equals("secionAdmin")) {
			ventanaAdmin.dibujar(datos, seccion);

		}
		if (seccion.equals("secionRecepcionista")) {
			ventanaRecepcionista.dibujar(datos, seccion);
		}
		if (seccion.equals("secionPersona")) {
			
			ventanaCliente.dibujar(datos, seccion);
		}
		
	}

	@Override
	public void borrar(String seccion) {
		if (seccion.equals("agregarProducto") || seccion.equals("agregarHabitacion") || seccion.equals("agregarRecepcionista")
				) {
			ventanaAdmin.borrar(seccion);
		}
		if (seccion.equals("registrar")) {
			ventanaRecepcionista.borrar(seccion);
		}
		
	}

	
}
