package crudRecepcionista;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import vista.Acciones;

public class EliminarRcecpcionista extends JPanel {

	private JList listaRecepcionista;
	private DefaultListModel modeloLista;
	private JScrollPane js;
	private JButton btnEliminar;
	private JButton btnSalir;

	public EliminarRcecpcionista() {

		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();

	}

	private void inicializar() {
		
		modeloLista = new DefaultListModel();
		listaRecepcionista = new JList(modeloLista);
		js = new JScrollPane(listaRecepcionista);
		btnEliminar = new JButton("eliminar");
		btnEliminar.setActionCommand(Acciones.BORRAR_RECEPCIONISTA);
		btnSalir = new JButton("salir");
		btnSalir.setActionCommand(Acciones.SALIR_ELIMINAR_RECEPCIONISTA);
		
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

	public JList getListaRecepcionista() {
		return listaRecepcionista;
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
