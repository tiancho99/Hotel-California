package crudRecepcionista;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vista.Acciones;

public class VerRecepcionista extends JPanel {
	private JTable tablaRecepcionista;
	private DefaultTableModel modeloTabla;
	private JScrollPane js;
	private JButton btnSalir;

	public VerRecepcionista() {
		setLayout(new FlowLayout());
		inicializar();
		caracteristicas();
		agregar();
		
		
	}

	private void inicializar() {
		
		modeloTabla = new DefaultTableModel();
		tablaRecepcionista = new JTable(modeloTabla);
		js = new JScrollPane(tablaRecepcionista);
		btnSalir = new JButton("atras");
		btnSalir.setActionCommand(Acciones.SALIR_VER_RECEPCIONISTA);
		
	}

	private void caracteristicas() {
		String[] cabecera = {"nombre", "apellido", "cedula", "N° licencia", "especialidad"};
		modeloTabla.setColumnIdentifiers(cabecera);
		js.setPreferredSize(new Dimension(400,250));
	}

	private void agregar() {
		add(js);
		add(btnSalir);
	}

	public JTable getTablaRecepcionista() {
		return tablaRecepcionista;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public JScrollPane getJs() {
		return js;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}
	
}
