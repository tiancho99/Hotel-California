package vista;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VerHistorial extends JPanel {
	private JTable tablaHistorial;
	private DefaultTableModel modeloTabla;
	private JScrollPane js;
	private JButton btnSalir;

	public VerHistorial() {
		setLayout(new FlowLayout());
		inicializar();
		caracteristicas();
		agregar();
		
		
	}

	private void inicializar() {
		
		modeloTabla = new DefaultTableModel();
		tablaHistorial = new JTable(modeloTabla);
		js = new JScrollPane(tablaHistorial);
		btnSalir = new JButton("atras");
		btnSalir.setActionCommand(Acciones.SALIR_VER_HISTORIAL);
		
	}

	private void caracteristicas() {
		String[] cabecera = {"recepcionista", "numeroHabitacion", "numero persona", "precio habitacion", "precio grupo"};
		modeloTabla.setColumnIdentifiers(cabecera);
		js.setPreferredSize(new Dimension(600,250));
	}

	private void agregar() {
		add(js);
		add(btnSalir);
	}

	public JTable getTablaHistorial() {
		return tablaHistorial;
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
