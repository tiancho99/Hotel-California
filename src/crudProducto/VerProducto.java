package crudProducto;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vista.Acciones;

public class VerProducto extends JPanel {
	private JTable tablaProducto;
	private DefaultTableModel modeloTabla;
	private JScrollPane js;
	private JButton btnSalir;

	public VerProducto() {
		setLayout(new FlowLayout());
		inicializar();
		caracteristicas();
		agregar();
		
		
	}

	private void inicializar() {
		
		modeloTabla = new DefaultTableModel();
		tablaProducto = new JTable(modeloTabla);
		js = new JScrollPane(tablaProducto);
		btnSalir = new JButton("salir");
		btnSalir.setActionCommand(Acciones.SALIR_VER_PRODUCTO);
		
	}

	private void caracteristicas() {
		String[] cabecera = { "nombre", "stock","precio", "codigo" };
		modeloTabla.setColumnIdentifiers(cabecera);
		js.setPreferredSize(new Dimension(400,250));
	}

	private void agregar() {
		add(js);
		add(btnSalir);
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public JButton getBtnAtras() {
		return btnSalir;
	}

	public JTable getTablaProducto() {
		return tablaProducto;
	}

	public JScrollPane getJs() {
		return js;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}
	
}
