package crudHabitacion;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import vista.Acciones;

public class CrearHabitacion extends JPanel {
//	numero, maximoPersonas, precioPersona, barra, aire, television, jacuzzi,
	
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblMaximoPersonas;
	private JTextField txtMaximoPersonas;
	private JLabel lblPrecioPersona;
	private JTextField txtPrecioPersona;
	private JCheckBox jcbBarra;
	private JCheckBox jcbAire;
	private JCheckBox jcbTelevision;
	private JCheckBox jcbJacuzzi;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCrear;
	private JButton btnSalir;
	
	public CrearHabitacion() {
		setLayout(null);
		inicializar();
		caracteristicas();
		agregar();
	}

	private void inicializar() {

		lblNumero = new JLabel("numero habitacion");
		txtNumero = new JTextField();
		lblMaximoPersonas = new JLabel("maximo personas");
		txtMaximoPersonas = new JTextField();
		lblPrecioPersona = new JLabel("precio persona");
		txtPrecioPersona = new JTextField();
		jcbBarra = new JCheckBox("barra de productos");
		jcbAire = new JCheckBox("aire acondicionado");
		jcbTelevision = new JCheckBox("television por cable");
		jcbJacuzzi = new JCheckBox("jacuzzi");
		btnSalir = new JButton("salir");
		btnSalir.setActionCommand(Acciones.SALIR_CREAR_HABITACION);
		btnCrear = new JButton("crear");
		btnCrear.setActionCommand(Acciones.AGREGAR_HABITACION);
		btnModificar = new JButton("modificar");
		btnModificar.setActionCommand(Acciones.EDITAR_HABITACION);
		btnEliminar = new JButton("eliminar");
		btnEliminar.setActionCommand(Acciones.BORRAR_HABITACION);
		
		
	}

	private void caracteristicas() {

		lblNumero.setBounds(20, 50, 150, 25);
		txtNumero.setBounds(160,50,150, 25);
		lblMaximoPersonas.setBounds(20, 100, 150, 25);
		txtMaximoPersonas.setBounds(160, 100, 150, 25);
		lblPrecioPersona.setBounds(20, 150, 150, 25);
		txtPrecioPersona.setBounds(160, 150, 150, 25);
		jcbBarra.setBounds(340, 50, 150, 25);
		jcbAire.setBounds(340, 100, 150, 25);
		jcbTelevision.setBounds(340, 150, 150, 25);
		jcbJacuzzi.setBounds(340, 200, 150, 25);
		btnCrear.setBounds(20, 230, 80, 25);
		btnModificar.setBounds(100, 230, 80, 25);
		btnEliminar.setBounds(180, 230, 80, 25);
		btnSalir.setBounds(510, 150, 80, 25);
		
	}

	private void agregar() {
		add(lblNumero);
		add(txtNumero);
		add(lblMaximoPersonas);
		add(txtMaximoPersonas);
		add(lblPrecioPersona);
		add(txtPrecioPersona);
		add(jcbBarra);
		add(jcbAire);
		add(jcbTelevision);
		add(jcbJacuzzi);
		add(btnCrear);
		add(btnModificar);
		add(btnEliminar);
		add(btnSalir);
		
	}

	public JTextField getTxtNumero() {
		return txtNumero;
	}

	public JTextField getTxtMaximoPersonas() {
		return txtMaximoPersonas;
	}

	public JTextField getTxtPrecioPersona() {
		return txtPrecioPersona;
	}


	public JCheckBox getJcbBarra() {
		return jcbBarra;
	}

	public JCheckBox getJcbAire() {
		return jcbAire;
	}

	public JCheckBox getJcbTelevision() {
		return jcbTelevision;
	}

	public JCheckBox getJcbJacuzzi() {
		return jcbJacuzzi;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}
	
	
}
