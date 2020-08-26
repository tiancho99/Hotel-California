package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import crudHabitacion.CrudHabitacion;
import crudProducto.CrudProducto;
import crudRecepcionista.CrudRecepcionista;

public class MenuCrudsAdmin extends JPanel {
	private JButton btnCrudProducto;
	private JButton btnCrudRecepcionista;
	private JButton btnCrudHabitacion;
	private JButton btnHistorial;
	
	public MenuCrudsAdmin() {
		setLayout(new GridLayout(2, 2));

		inicializar();
		caracteristicas();
		agregar();
	}

	private void inicializar() {
			btnCrudHabitacion = new JButton("CRUD HABITACION");
			btnCrudHabitacion.setActionCommand(Acciones.CREAR_HABITACION);
			btnCrudProducto = new JButton("CRUD PRODUCTO");
			btnCrudProducto.setActionCommand(Acciones.CREAR_PRODUCTO);
			btnCrudRecepcionista = new JButton("CRUD RECEPCIONISTA");
			btnCrudRecepcionista.setActionCommand(Acciones.CREAR_RECEPCIONISTA);
			btnHistorial = new JButton("HISTORIAL");
			btnHistorial.setActionCommand(Acciones.VER_HISTORIAL);
	}

	private void caracteristicas() {
		// TODO Auto-generated method stub
		
	}

	private void agregar() {
 
		add(btnCrudHabitacion);
		add(btnCrudRecepcionista);
		add(btnCrudProducto);
		add(btnHistorial);
	}

	public JButton getBtnCrudProducto() {
		return btnCrudProducto;
	}

	public JButton getBtnCrudRecepcionista() {
		return btnCrudRecepcionista;
	}

	public JButton getBtnCrudHabitacion() {
		return btnCrudHabitacion;
	}

	public JButton getBtnHistorial() {
		return btnHistorial;
	}
	
	
}
