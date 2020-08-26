package crudProducto;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.Acciones;

public class MenuProducto extends JPanel {
	private JButton btnCrear;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVer;
	
	public MenuProducto() {
		setLayout(new FlowLayout());
		
		inicializar();
		caracteristicas();
		agregar();
	}

	private void inicializar() {
		btnCrear = new JButton("crud producto");
		btnCrear.setActionCommand(Acciones.CREAR_PRODUCTO);
		btnModificar = new JButton("modificar producto");
		btnModificar.setActionCommand(Acciones.MODIFICAR_PRODUCTO);
		btnEliminar = new JButton("eliminar producto");
		btnEliminar.setActionCommand(Acciones.ELIMINAR_PRODUCTO);
		btnVer = new JButton("ver producto");
		btnVer.setActionCommand(Acciones.VER_PRODUCTO);
	}

	private void caracteristicas() {
		// TODO Auto-generated method stub
		
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
