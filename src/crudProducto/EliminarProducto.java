package crudProducto;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import vista.Acciones;

public class EliminarProducto extends JPanel  {

	private JList listaProductos;
	private DefaultListModel modeloLista;
	private JScrollPane js;
	private JButton btnEliminar;
	private JButton btnSalir;

	public EliminarProducto() {

		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();

	}

	private void inicializar() {
		
		modeloLista = new DefaultListModel();
		listaProductos = new JList(modeloLista);
		js = new JScrollPane(listaProductos);
		btnEliminar = new JButton("eliminar");
		btnEliminar.setActionCommand(Acciones.BORRAR_PRODUCTO);
		btnSalir = new JButton("salir");
		btnSalir.setActionCommand(Acciones.SALIR_ELIMINAR_PRODUCTO);
		
	}

	private void caracteristicas() {
		js.setBounds(200, 0, 400, 300);
		btnEliminar.setBounds(50, 50, 80, 25);
		btnSalir.setBounds(50, 100, 80, 25);
	}

	private void agregar() {
		add(js);
		add(btnEliminar);
		add(btnSalir);
	}

	public JList getListaProductos() {
		return listaProductos;
	}

	public DefaultListModel getModeloLista() {
		return modeloLista;
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
	
	
}
