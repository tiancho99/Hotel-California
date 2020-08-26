package crudRecepcionista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vista.Acciones;

public class ModificarRecepcionista extends JPanel {

	private DefaultTableModel modeloTabla;
	private JTable jtbTablaRecepcionista;
	private JScrollPane js;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnEditar;
	private JButton btnSalir;
	
	public ModificarRecepcionista() {
		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();
		
	}
	private void inicializar() {
		
		modeloTabla = new DefaultTableModel();
		jtbTablaRecepcionista = new JTable(modeloTabla);
		js = new JScrollPane(jtbTablaRecepcionista);
		btnSalir = new JButton("salir");
		btnSalir.setActionCommand(Acciones.SALIR_MODIFICAR_RECEPCIONISTA);
		btnEditar = new JButton("editar");
		btnEditar.setActionCommand(Acciones.EDITAR_RECEPCIONISTA);

		}	
		
	
	private void caracteristicas() {
		js.setBounds(10, 10, 600, 300);;
		String[] cabecera = { "documento", "nombre", "apellido", "ciudad", "nacimiento", "celular", "contraseña", "ventas"};
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
	public JTable getJtbTablaRecepcionista() {
		return jtbTablaRecepcionista;
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
