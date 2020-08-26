package crudHabitacion;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vista.Acciones;

public class RudHabitacion extends JPanel {
	
	
	private JTable listaClientes;
	private DefaultTableModel modeloTabla;
	private JScrollPane js;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JButton btnModificar;
	

	public RudHabitacion() {

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
		btnModificar.setActionCommand(Acciones.EDITAR_HABITACION);
		btnEliminar = new JButton("eliminar");
		btnEliminar.setActionCommand(Acciones.BORRAR_HABITACION);
		btnSalir = new JButton("salir");
		btnSalir.setActionCommand(Acciones.SALIR_CRUD_HABITACION);
		
		
	}

	private void caracteristicas() {
		String[] cabecera = {"numero", "max personas", "precio persona", "barra", "aire", "tv", "jacuzzi", "disponible"};
		modeloTabla.setColumnIdentifiers(cabecera);
		js.setBounds(10, 10, 600, 300);
		btnModificar.setBounds(50, 50, 100, 25);
		btnEliminar.setBounds(50, 100, 100, 25);
		btnSalir.setBounds(50, 150, 100, 25);
	}

	private void agregar() {
		add(js);
		
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
