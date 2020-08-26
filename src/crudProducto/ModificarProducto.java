package crudProducto;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import vista.Acciones;

public class ModificarProducto extends JPanel {
	private DefaultTableModel modeloTabla;
	private JTable jtbTablaPrducto;
	private JScrollPane js;
	private JButton btnEditar;
	private JButton btnSalir;
	
	public ModificarProducto() {
		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();
		
	}
	private void inicializar() {
		
		modeloTabla = new DefaultTableModel();
		jtbTablaPrducto = new JTable(modeloTabla);
		js = new JScrollPane(jtbTablaPrducto);
		btnSalir = new JButton("salir");
		btnSalir.setActionCommand(Acciones.SALIR_MODIFICAR_PRODUCTO);
		btnEditar = new JButton("editar");
		btnEditar.setActionCommand(Acciones.EDITAR_PRODUCTO);
		
		}	
		
	
	private void caracteristicas() {
		js.setBounds(10, 10, 600, 300);;
		String[] cabecera = { "nombre", "stock","precio", "codigo" };
		modeloTabla.setColumnIdentifiers(cabecera);
		btnEditar.setBounds(215, 280, 80, 25);
		btnSalir.setBounds(295, 280, 80, 25);
		
		}
	

	private void agregar() {
		add(js);
		
		
	}
	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}
	public JTable getJtbTablaProducto() {
		return jtbTablaPrducto;
	}
	public JScrollPane getJs() {
		return js;
	}
	public JButton getBtnEditar() {
		return btnEditar;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
	
	
}
