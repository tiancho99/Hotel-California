package crudHabitacion;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.Acciones;

public class MenuHabitacion extends JPanel{

	private JButton btnCrear;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVer;
	
	public MenuHabitacion() {
		setLayout(new GridLayout(4, 1, 0, 30));
		
		inicializar();
		caracteristicas();
		agregar();
	}

	private void inicializar() {
		btnCrear = new JButton("crud habitacion");
		btnCrear.setActionCommand(Acciones.CREAR_HABITACION);
		btnModificar = new JButton("modificar habitacion");
		btnModificar.setActionCommand(Acciones.MODIFICAR_HABITACION);
		btnEliminar = new JButton("eliminar habitacion");
		btnEliminar.setActionCommand(Acciones.ELIMINAR_HABITACION);
		btnVer = new JButton("ver habitacion");
		btnVer.setActionCommand(Acciones.VER_HABITACION);
	}

	private void caracteristicas() {

		
	}

	private void agregar() {
		add(btnCrear);
		
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnVer() {
		return btnVer;
	}
	
}
