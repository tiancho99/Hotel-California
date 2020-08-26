package crudCliente;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vista.Acciones;

public class VentanaReserva extends JPanel {
	
	private JLabel titulo;
	private ButtonGroup btnGroup;
	private JRadioButton jcBarraProductos;
	private JRadioButton jcAire;
	private JRadioButton jcTelevision;
	private JRadioButton jcJacuzzi;
	private JRadioButton jcReestablecer;
	private DefaultTableModel modeloTabla;
	private JTable jtbTablaHabitaciones;
	private JScrollPane js;
	private JButton btnAsignar;
	private JButton btnSalir;
	public VentanaReserva() {
		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();
		

	
	}

	private void inicializar() {
		titulo = new JLabel("HABITACIONES");
		jcBarraProductos = new JRadioButton("Barra de productos");
		btnGroup = new ButtonGroup();
		jcAire = new JRadioButton("Aire acondicionado");
		jcTelevision = new JRadioButton("Television por cable");
		jcJacuzzi = new JRadioButton("jacuzzi");
		jcReestablecer = new JRadioButton("Ver todas");
		btnAsignar = new JButton("seleccionar");
		btnSalir = new JButton("salir");
		modeloTabla = new DefaultTableModel();
		jtbTablaHabitaciones = new JTable(modeloTabla);
		js = new JScrollPane(jtbTablaHabitaciones);
	}

	private void caracteristicas() {
		
		titulo.setBounds(210, 0, 150, 20);
		jcBarraProductos.setBounds(20, 40, 150 ,20);
		btnGroup.add(jcBarraProductos);
		btnGroup.add(jcAire);
		btnGroup.add(jcTelevision);
		btnGroup.add(jcJacuzzi);
		btnGroup.add(jcReestablecer);
		jcBarraProductos.setActionCommand(Acciones.FILTRAR_BARRA); 
		jcAire.setBounds(20, 90, 150 ,20);
		jcAire.setActionCommand(Acciones.FILTRAR_BARRA);
		jcTelevision.setBounds(20, 140,150 ,20);
		jcTelevision.setActionCommand(Acciones.FILTRAR_BARRA);
		jcJacuzzi.setBounds(20, 190,150 ,20);
		jcJacuzzi.setActionCommand(Acciones.FILTRAR_BARRA);
		jcReestablecer.setBounds(20, 240,150 ,20);
		jcReestablecer.setActionCommand(Acciones.REESTABLECER);
		jcReestablecer.setSelected(true);
		btnAsignar.setBounds(20, 280,130 ,25);
		btnAsignar.setActionCommand(Acciones.ASIGNAR_HABITACION);
		btnSalir.setBounds(40, 280,100 ,25);
		btnSalir.setActionCommand(Acciones.SALIR_RESERVA);
		String[] cabecera = {"numero", "max personas", "precio persona", "barra", "aire", "tv", "jacuzzi", "disponible"};
		modeloTabla.setColumnIdentifiers(cabecera);
		js.setBounds(170, 40, 570, 270);
	}

	private void agregar() {

	add(titulo);
	add(jcBarraProductos);
	add(jcAire);
	add(jcTelevision);
	add(jcJacuzzi);
	add(btnAsignar);
	add(js);
	add(jcReestablecer);
	}

	public JRadioButton getJcBarraProductos() {
		return jcBarraProductos;
	}

	public JRadioButton getJcAire() {
		return jcAire;
	}

	public JRadioButton getJcTelevision() {
		return jcTelevision;
	}

	public JRadioButton getJcJacuzzi() {
		return jcJacuzzi;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public JTable getJtbTablaHabitaciones() {
		return jtbTablaHabitaciones;
	}

	public JScrollPane getJs() {
		return js;
	}

	public JButton getBtnAsignar() {
		return btnAsignar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JRadioButton getJcReestablecer() {
		return jcReestablecer;
	}
	

}
