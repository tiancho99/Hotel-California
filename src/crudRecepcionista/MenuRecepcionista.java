package crudRecepcionista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.Acciones;

public class MenuRecepcionista extends JPanel {
	private JButton btnCrear;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVer;
	
	public MenuRecepcionista() {
		setLayout(new GridLayout(4, 1, 0, 30));
		
		inicializar();
		caracteristicas();
		agregar();
	}

	private void inicializar() {
		btnCrear = new JButton("crear recepcionista");
		btnCrear.setActionCommand(Acciones.CREAR_RECEPCIONISTA);
		btnModificar = new JButton("modificar recepcionista");
		btnModificar.setActionCommand(Acciones.MODIFICAR_RECEPCIONISTA);
		btnEliminar = new JButton("eliminar recepcionista");
		btnEliminar.setActionCommand(Acciones.ELIMINAR_RECEPCIONISTA);
		btnVer = new JButton("ver recepcionista")	;
		btnVer.setActionCommand(Acciones.VER_RECEPCIONISTA);
	}

	private void caracteristicas() {
		// TODO Auto-generated method stub
		
	}

	private void agregar() {
		add(btnCrear);
		add(btnModificar);
		add(btnEliminar);
		add(btnVer);
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
