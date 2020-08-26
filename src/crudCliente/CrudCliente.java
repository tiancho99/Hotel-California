package crudCliente;

import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vista.Acciones;

public class CrudCliente extends JPanel {
	private JTable listaClientes;
	private DefaultTableModel modeloTabla;
	private JScrollPane js;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JButton btnModificar;
	

	public CrudCliente() {

		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();

	}

	private void inicializar() {
		
		modeloTabla = new DefaultTableModel();
		listaClientes = new JTable(modeloTabla);
		js = new JScrollPane(listaClientes);
		btnModificar = new JButton("modificar");
		btnModificar.setActionCommand(Acciones.EDITAR_CLIENTE);
		btnEliminar = new JButton("check out");
		btnEliminar.setActionCommand(Acciones.BORRAR_CLIENTE);
		btnSalir = new JButton("salir");
		btnSalir.setActionCommand(Acciones.SALIR_CRUD_CLIENTE);
		
		
	}
	
	private void caracteristicas() {
		String[] cabecera = {"documento",  "nombre",  "apellido", " ciudad",  "nacimiento", "celular",  "contraseña"};
		modeloTabla.setColumnIdentifiers(cabecera);
		js.setBounds(160, 20, 580, 300);
		btnModificar.setBounds(50, 50, 100, 25);
		btnEliminar.setBounds(50, 100, 100, 25);
		btnSalir.setBounds(50, 150, 100, 25);
	}

	private void agregar() {
		add(js);
		add(btnEliminar);
		add(btnModificar);
		add(btnSalir);
	}

	public JTable getListaClientes() {
		return listaClientes;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public JScrollPane getJs() {
		return js;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}
	
}
